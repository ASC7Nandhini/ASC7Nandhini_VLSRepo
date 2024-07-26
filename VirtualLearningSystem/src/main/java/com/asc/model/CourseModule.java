package com.asc.model;

import java.time.Duration;

public class CourseModule {
    private int courseId;
    private String courseName;
    private String authorName;
    private Duration durationInHours;
    boolean availability;

    public CourseModule(int courseId,String courseName,String authorName,Duration durationInHours,boolean availability){
        this.courseId=courseId;
        this.courseName=courseName;
        this.authorName=authorName;
        this.durationInHours=durationInHours;
        this.availability=availability;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Duration getDurationInHours() {
        return durationInHours;
    }

    public void setDurationInHours(Duration durationInHours) {
        this.durationInHours = durationInHours;
    }

    public boolean getIsAvailability() {
        return availability;
    }

    public void setIsAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "CourseModule = {" +
                "CourseId=" + courseId +
                ", CourseName='" + courseName + '\'' +
                ", AuthorName='" + authorName + '\'' +
                ", Duration=" + durationInHours +
                ", CourseAvailability=" + availability +
                '}';
    }
}
