package projects.service;

import java.util.List;
import java.util.NoSuchElementException;

import projects.dao.ProjectDao;
import projects.entity.Project;
import projects.exception.DbException;



public class ProjectService {
   private ProjectDao projectDao = new ProjectDao();

public ProjectDao getProjectDao() {
	return projectDao;
}

public void setProjectDao(ProjectDao projectDao) {
	this.projectDao = projectDao;
}

public Project addProject(Project project) throws DbException {
	;
	try {
		return projectDao.insertProject(project);
	} catch (Throwable e) {
		e.printStackTrace();
	}
	return project;
}

public List<Project> fetchAllProjects() {
	return projectDao.fetchAllProjects();
}

public Project fetchProjectById(Integer projectId) {
	return projectDao.fetchProjectById(projectId).orElseThrow(() -> new NoSuchElementException("Project with projectID=" + projectId + " des not exist."));
}

public void deleteProject(Integer projectId) {
  if(!projectDao.deleteProject(projectId)) {
	  throw new DbException("Project with ID=" + projectId + " does not exist.");
	  
  }
	
}

public void modifyProjectDetails(Project project) {
  if(!projectDao.modifyProjectDetails(project)) {
	throw new DbException("Project with ID=" + project.getProjectId() + " does not exist.");
  }
}
}
   
   
