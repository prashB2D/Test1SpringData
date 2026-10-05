package com.prashu.Test1;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.prashu.Test1.Modules.Department;
import com.prashu.Test1.Modules.Employee;
import com.prashu.Test1.Modules.Project;
import com.prashu.Test1.Repositery.IrepoDepattment; // Using your exact interface name
import com.prashu.Test1.Serveice.EMpployeeService;

@SpringBootApplication
public class Test1Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Test1Application.class, args);

        EMpployeeService empBean = ioc.getBean(EMpployeeService.class);
        IrepoDepattment deptRepo = ioc.getBean(IrepoDepattment.class); // Matched here

        // 1. Projects
        Project p1 = new Project("Alpha", true, 100000, LocalDate.of(2024, 1, 1), new HashSet<>());
        Project p2 = new Project("Beta", false, 250000, LocalDate.of(2024, 3, 15), new HashSet<>());
        Project p3 = new Project("Gamma", true, 80000, LocalDate.of(2024, 6, 10), new HashSet<>());

        // 2. Departments
        Department d1 = new Department("IT", "Pune", new BigDecimal("500000"), new ArrayList<>());
        Department d2 = new Department("HR", "Mumbai", new BigDecimal("200000"), new ArrayList<>());
        Department d3 = new Department("Finance", "Delhi", new BigDecimal("300000"), new ArrayList<>());

        // 3. Employees
        List<Employee> emps = List.of(
            new Employee("Ravi",   "ravi@gmail.com",   45000, LocalDate.of(2022,1,10),  d1, Set.of(p1)),
            new Employee("Arjun",  "arjun@gmail.com",  38000, LocalDate.of(2023,3,5),   d1, Set.of(p3)),
            new Employee("Rahul",  "rahul@gmail.com",  29000, LocalDate.of(2023,7,12),  d1, Set.of(p2)),
            new Employee("Vikram", "vikram@gmail.com", 66000, LocalDate.of(2021,9,18),  d1, Set.of(p2)),
            new Employee("Sita",   "sita@gmail.com",   52000, LocalDate.of(2021,6,15),  d2, Set.of(p1, p2)),
            new Employee("Kiran",  "kiran@gmail.com",  47000, LocalDate.of(2022,8,1),   d2, Set.of(p3)),
            new Employee("Deepa",  "deepa@gmail.com",  41000, LocalDate.of(2022,12,25), d2, Set.of(p3)),
            new Employee("Nisha",  "nisha@gmail.com",  35000, LocalDate.of(2023,10,30), d2, Set.of(p2)),
            new Employee("Priya",  "priya@gmail.com",  61000, LocalDate.of(2020,11,20), d3, Set.of(p2)),
            new Employee("Meena",  "meena@gmail.com",  55000, LocalDate.of(2021,2,28),  d3, Set.of(p1)),
            new Employee("Anjali", "anjali@gmail.com", 72000, LocalDate.of(2020,5,3),   d3, Set.of(p1, p3)),
            new Employee("Suresh", "suresh@gmail.com", 83000, LocalDate.of(2019,4,7),   d3, Set.of(p1, p2))
        );

        // 4. Set bidirectional references
        for (Employee e : emps) {
            e.getDept().getEmploy().add(e);
            for (Project p : e.getProj()) {
                p.getEmp().add(e);
            }
        }

        // 5. Save all departments (Cascades to Employee & Project)
        deptRepo.saveAll(List.of(d1, d2, d3));

        System.out.println("=== Departments ===");
        deptRepo.findAll().forEach(System.out::println);

        System.out.println("=== Employees ===");
        empBean.findAllEmp();
    }
}