package com.asc.service;

import com.asc.model.CourseModule;
import com.asc.repository.CourseRepositroy;
import com.asc.repository.CourseRepositoryDatabaseImpl;

import java.util.List;

public class CourseServiceImpl implements CourseService{
    CourseRepositroy courseRepositroyDatabaseImpl=new CourseRepositoryDatabaseImpl();
    public void addCourse(CourseModule courseModule){
        courseRepositroyDatabaseImpl.addCourse(courseModule);
    }
    public List<CourseModule> displayCourse(){
        return courseRepositroyDatabaseImpl.displayCourse();
    }
    public boolean searchCourse(int courseId){
        return courseRepositroyDatabaseImpl.searchCourse(courseId);
    }
    public void deleteCourse(int courseId){
        courseRepositroyDatabaseImpl.deleteCourse(courseId);
    }
}
