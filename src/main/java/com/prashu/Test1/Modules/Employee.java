package com.prashu.Test1.Modules;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false) // make shore name is not null 
	private String name;
	private String email;
	@Column(columnDefinition = "integer check (sal >= 0)")
	private Integer sal;
	
	private LocalDate joinDate;
	@ManyToOne(fetch = FetchType.LAZY ,cascade = CascadeType.PERSIST)
	@JoinColumn
	private Department dept;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	@JoinTable(joinColumns =  @JoinColumn(name ="Employee_ID"),
			 inverseJoinColumns = @JoinColumn(name ="Project_ID"))
	private Set<Project> proj;

	public Employee(String name, String email, Integer sal, LocalDate joinDate, Department dept, Set<Project> proj) {
		super();
		this.name = name;
		this.email = email;
		this.sal = sal;
		this.joinDate = joinDate;
		this.dept = dept;
		this.proj = proj;
	}

	public Department getDept() {
	    return dept;
	}

	public Set<Project> getProj() {
	    return proj;
	}
	Employee(){
		
	}
	
	

	
	

}
