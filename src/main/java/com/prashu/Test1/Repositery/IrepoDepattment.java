package com.prashu.Test1.Repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prashu.Test1.Modules.Department;

@Repository
public interface IrepoDepattment extends JpaRepository<Department, Integer>{

}
