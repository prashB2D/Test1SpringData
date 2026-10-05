package com.prashu.Test1.Modules;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String location;
	private BigDecimal budget;
	@OneToMany(mappedBy ="dept" ,cascade = CascadeType.PERSIST )
	private List<Employee> employ ;
	
	
	@Override
	public String toString() {
		return "Department [id=" + id + ", nmae=" + name + ", location=" + location + ", budget=" + budget + "]";
	}


	public Department(String name, String location, BigDecimal budget, List<Employee> employ) {
		super();
		this.name = name;
		this.location = location;
		this.budget = budget;
		this.employ = employ;
	}

	public List<Employee> getEmploy() {
	    return employ;
	}

	// Add this explicitly:
	public Department() {
	}

	
	

}
