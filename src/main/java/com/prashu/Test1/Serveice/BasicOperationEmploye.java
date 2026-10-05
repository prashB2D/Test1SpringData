package com.prashu.Test1.Serveice;

import java.util.List;

import com.prashu.Test1.Modules.Employee;

public interface BasicOperationEmploye {
	
	 void saveEmp(Employee emp) ;
	 void saveAllEmp(List<Employee> li);
	 void findEmpById(Integer id);
	 void findAllEmp() ;
	 void deleteEmpById(Integer id);
	// -------- DERIVED  QURRY
	 void findEmpByName(String Name);
	 void findEmpsBySal(Integer Sal);
	 void findEmpsByDept(Integer deptNum);
	 
	 //
	 
	 // paging and sorting
	     void  nextPage(int size);

}
