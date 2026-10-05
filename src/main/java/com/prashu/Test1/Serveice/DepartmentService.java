package com.prashu.Test1.Serveice;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.prashu.Test1.Modules.Department;
import com.prashu.Test1.Repositery.IrepoDepattment;
@Service
public class DepartmentService  implements BasicOperationDepartment  {
	
	IrepoDepattment repo;
	DepartmentService(IrepoDepattment repo){
		this.repo=repo;
	}
	
	

	@Override
	public void saveDept(Department dept) {
		
		repo.save(dept);
		
	}

	@Override
	public void saveAllDept(List<Department> li) {
		repo.saveAll(li);
		
	}

	@Override
	public void findDeptById(Integer id) {
		Optional<Department> op = repo.findById(id);
		if(op.isPresent()){
			System.out.println(op.get());
		}else {
			System.out.println(" there no emp with this ID");
		}
	}

	@Override
	public void findAllDept() {
		List<Department> li = repo.findAll();
		li.forEach(v->System.out.println(v));
		
	}

	@Override
	public void deleteDeptById(Integer id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			System.out.println(" the recored deleted ");
		}else {
			System.out.println(" thre is no  recored found in that ID");
		}
		
	}

}
