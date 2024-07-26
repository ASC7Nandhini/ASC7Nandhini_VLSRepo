package com.asc.ui;

import com.asc.model.CourseModule;
import com.asc.service.CourseService;
import com.asc.service.CourseServiceImpl;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

public class Menu {
    CourseService courseServiceImpl=new CourseServiceImpl();
    Scanner sc=new Scanner(System.in);

    public void displayMenu(){
        System.out.println("1. Add course to the cart");
        System.out.println("2. Display the details of the courses");
        System.out.println("3. Search for courses by author or course name");
        System.out.println("4. Delete courses from the cart");
        System.out.println("Other values will exist");
    }

    public int getChoice(){
        return sc.nextInt();
    }

    public CourseModule getCourseModule(){
        System.out.println("Enter Course Id: ");
        int courseId= sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Course Name: ");
        String courseName=sc.nextLine();
        System.out.println("Enter Author Name: ");
        String authorName=sc.nextLine();
        System.out.println("Enter Duration InHours: ");
        Duration durationInHours=Duration.ofHours(sc.nextLong());
        System.out.println("Enter course is Available or not: ");
        boolean courseIsAvailable=sc.nextBoolean();
        return new CourseModule(courseId,courseName,authorName,durationInHours,courseIsAvailable);
    }
    public void addCourse(CourseModule courseModule){

        courseServiceImpl.addCourse(courseModule);
    }
    public void displayCourse(){
        List<CourseModule> courseModuleList=courseServiceImpl.displayCourse();
        for (CourseModule courseModule : courseModuleList){
            System.out.println(courseModule);
        }
    }
    public void searchCourse(){
        System.out.println("Enter CourseId for search: ");
        boolean courseFound= courseServiceImpl.searchCourse(sc.nextInt());
        if(courseFound){
            System.out.println("CourseModule Found");
        }
        else {
            System.out.println("CourseModule Not Found");
        }
    }
    public void deleteCourse(){
        System.out.println("Enter CurseId for delete: ");
        courseServiceImpl.deleteCourse(sc.nextInt());
    }
}
