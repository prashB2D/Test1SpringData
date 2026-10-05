package com.prashu.Test1.Serveice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable; // CORRECT
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.prashu.Test1.Modules.Employee;
import com.prashu.Test1.Repositery.IrepoEmploye;
@Service
public class EMpployeeService implements BasicOperationEmploye{
	
	IrepoEmploye repo;

	EMpployeeService(@Autowired IrepoEmploye repo){
		this.repo=repo;
	}
	
	@Override
	public void saveEmp(Employee emp) {
		
		repo.save(emp);
	}

	@Override
	public void findEmpById(Integer id) {
		Optional<Employee> op = repo.findById(id);
		if(op.isPresent()){
			System.out.println(op.get());
		}else {
			System.out.println(" there no emp with this ID");
		}
	}

	@Override
	public void findAllEmp() {
		
		List<Employee> li = repo.findAll();
		li.forEach(v->System.out.println(v));
	}

	@Override
	public void deleteEmpById(Integer id){
		if(repo.existsById(id)) {
			repo.deleteById(id);
			System.out.println(" the recored deleted ");
		}else {
			System.out.println(" thre is no  recored found in that ID");
		}
		
		
	}

	@Override
	public void saveAllEmp(List<Employee> li) {
		int addingNum =li.size();
		long exextingNum=repo.count();
		long shudeBe=addingNum+exextingNum;
	 repo.saveAll(li);
	 if(shudeBe==repo.count()) {
		 System.out.println("  all recored added susfully");
	 }else {
		long   missing = shudeBe-repo.count();
				
		 System.out.println(" this num rec faild to add"+ missing);
	 }
	
		
	}
	// -------- DERIVED  QURRY

	@Override
	public void findEmpByName(String Name) {
		List<Employee> result = repo.findBynameContainingIgnoreCase(Name);
		System.out.println(result);
	}

	@Override
	public void findEmpsBySal(Integer Sal) {
		List<Employee> results = repo.findBysal(Sal);
		results.forEach(v->System.out.println(v));
		
	}

	@Override
	public void findEmpsByDept(Integer deptNum) {
		List<Employee> results = repo.findBydept(deptNum);
		results.forEach(v->System.out.println(v));
		
	}


	int currentPage = 0;

	@Override
	public void nextPage(int size) {
	    long totalElements = repo.count();

	    // Guard against empty database to avoid divide-by-zero/out-of-bounds issues
	    if (totalElements == 0) {
	        System.out.println("No records found.");
	        return;
	    }

	    int totalPages = (int) Math.ceil((double) totalElements / size);

	    // Reset loop: if currentPage reaches or exceeds totalPages, wrap around back to 0
	    if (currentPage >= totalPages) {
	        currentPage = 0;
	    }

	    Sort sort = Sort.by(Sort.Direction.ASC, "name");
	    
	    // Pass current page index, then increment for the NEXT method call
	    Pageable pageable = PageRequest.of(currentPage, size, sort);
	    Page<Employee> pageResult = repo.findAll(pageable);

	    // Move state forward for next call
	    currentPage++;

	    // Print or process page contents
	    pageResult.getContent().forEach(emp -> System.out.println(emp));
	}
	
	
	
	

}
