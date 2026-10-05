package com.prashu.Test1.Repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prashu.Test1.Modules.Employee;

@Repository
public interface IrepoEmploye extends JpaRepository<Employee,Integer> {
	
	public List<Employee> findBysal(Integer Sal);
	public List<Employee> findBynameContainingIgnoreCase(String Nmae);
	public List<Employee> findBydept(Integer deptNum);
	
	// Query Method
	@Query(value ="SELECT DISTINCT e.* FROM employee e "   // will not give other field type 
			+"INNER JOIN department d ON e.dept_id=d.id "
			+"INNER JOIN employee_proj ep ON e.id=ep.employee_id "
			+"INNER JOIN project p ON ep.project_id=p.id",
			nativeQuery = true)
	public List<Employee> optimisedFindAll();
	
	
	     													// fields 				// fields 
	@Query("SELECT DISTINCT e FROM Employee e LEFT JOIN FETCH e.dept LEFT JOIN FETCH e.proj") // works on the fields name
	List<Employee> findAllWithRelations();
	
//	Fetch employees with a salary above an average,
	@Query(value ="SELECT DISTINCT e.* FROM  employee e  "
		  + "WHERE e.sal>(SELECT AVG(ee.sal) FROM employee ee)",
		  nativeQuery = true)
	List<Employee> empWithSalGraterThanAVG();
	
	@Query("SELECT e FROM Employee e WHERE e.sal > (SELECT AVG(ee.sal) FROM Employee ee)")
	List<Employee> empWithSalGraterThanAVGJPQL();
	
//  count employees in a department.           		//field holds obj soo we have use id 
	@Query("SELECT COUNT(e.id) FROM  Employee e where e.dept.id=:deptNum ")
	Integer numberOfEmpInDept(@Param("deptNum") Integer id);
	
	
//	Find all employees assigned to a specific ProjectId.
	@Query("SELECT DISTINCT e FROM Employee e JOIN FETCH e.proj p WHERE p.id=:projId")
	List<Employee> empAssinedToPoj(@Param("projId")Integer projId);
	
	
	
	

}
