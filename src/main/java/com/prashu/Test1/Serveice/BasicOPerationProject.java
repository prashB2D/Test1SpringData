package com.prashu.Test1.Serveice;

import java.util.List;

import com.prashu.Test1.Modules.Project;

public interface BasicOPerationProject {

	
	 void saveProj(Project emp) ;
	 void saveAllProj(List<Project> li);
	 void findProjById(Integer id);
	 void findAllProj() ;
	 void deleteProjById(Integer id);
}
