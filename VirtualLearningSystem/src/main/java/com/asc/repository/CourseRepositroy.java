package com.asc.repository;

import com.asc.model.CourseModule;

import java.util.List;

public interface CourseRepositroy {
    void addCourse(CourseModule courseModule);
    List<CourseModule> displayCourse();
    boolean searchCourse(int courseId);
    void deleteCourse(int courseId);
}
