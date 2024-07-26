package com.asc.service;

import com.asc.model.CourseModule;

import java.util.List;

public interface CourseService {
    void addCourse(CourseModule courseModule);
    List<CourseModule> displayCourse();
    boolean searchCourse(int courseId);
    void deleteCourse(int courseId);
}
