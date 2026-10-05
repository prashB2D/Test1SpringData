package com.prashu.Test1.Repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prashu.Test1.Modules.Project;


@Repository
public interface IrepoProject extends JpaRepository<Project, Integer> {

}
