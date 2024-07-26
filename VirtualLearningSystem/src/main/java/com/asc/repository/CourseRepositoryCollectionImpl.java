package com.asc.repository;

import com.asc.exception.CourseNotFoundException;
import com.asc.exception.DuplicateCourseException;
import com.asc.model.CourseModule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseRepositoryCollectionImpl implements CourseRepositroy{
    Map<Integer, CourseModule> courseModuleMap = new HashMap<>();
    public void addCourse(CourseModule courseModule){
        try{
            if(courseModuleMap.containsKey(courseModule.getCourseId())){
                throw new DuplicateCourseException("Course Already Available");
            }
            courseModuleMap.put(courseModule.getCourseId(),courseModule);
        }
        catch (DuplicateCourseException duplicateCourseException){
            System.out.println(duplicateCourseException.getMessage());
        }
    }
    public List<CourseModule> displayCourse(){
        List<CourseModule> courseModuleList = new ArrayList<>();
        for(Map.Entry<Integer,CourseModule> courseModuleMapEntry : courseModuleMap.entrySet()){
            courseModuleList.add(courseModuleMapEntry.getValue());
        }
        return courseModuleList;
    }
    public boolean searchCourse(int courseId){
        boolean courseFound=false;
        try {
            if(courseModuleMap.containsKey(courseId)){
                courseFound=true;
            }
            throw new CourseNotFoundException("Course Not Exists");
        }
        catch (CourseNotFoundException courseNotFoundException){
            System.out.println(courseNotFoundException.getMessage());
        }
        return courseFound;
    }
    public void deleteCourse(int courseId){
        try {
            if(courseModuleMap.containsKey(courseId)){
                courseModuleMap.remove(courseId);
            }
            throw new CourseNotFoundException("Course Not Exists");
        }
        catch (CourseNotFoundException courseNotFoundException){
            System.out.println(courseNotFoundException.getMessage());
        }
    }
}
