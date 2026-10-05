package com.prashu.Test1.Modules;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false)
	private String name;
	private Boolean states;
	@Column(columnDefinition = "integer check (budget >= 0)")
	private Integer budget;
	private LocalDate stDate;
	
	@ManyToMany(cascade = CascadeType.PERSIST , mappedBy = "proj")
	private Set<Employee> emp;

	@Override
	public String toString() {
		return "Project [id=" + id + ", nmae=" + name + ", states=" + states + ", budget=" + budget + ", stDate="
				+ stDate + "]";
	}

	public Project(String name, Boolean states, Integer budget, LocalDate stDate, Set<Employee> emp) {
		super();
		this.name = name;
		this.states = states;
		this.budget = budget;
		this.stDate = stDate;
		this.emp = emp;
	}

	public Set<Employee> getEmp() {
	    return emp;
	}
	Project(){
		
	}
	


}
