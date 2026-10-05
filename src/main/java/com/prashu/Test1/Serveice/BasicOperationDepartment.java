package com.prashu.Test1.Serveice;

import java.util.List;

import com.prashu.Test1.Modules.Department;

public interface BasicOperationDepartment {
	
	 void saveDept(Department dept) ;
	 void saveAllDept(List<Department> li);
	 void findDeptById(Integer id);
	 void findAllDept() ;
	 void deleteDeptById(Integer id);

}
