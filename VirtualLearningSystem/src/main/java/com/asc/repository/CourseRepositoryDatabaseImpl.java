package com.asc.repository;

import com.asc.exception.DuplicateCourseException;
import com.asc.model.CourseModule;

import java.sql.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseRepositoryDatabaseImpl implements CourseRepositroy{
    Scanner sc=new Scanner(System.in);
    public void addCourse(CourseModule courseModule){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1/VLSDB","root","mysql");
            System.out.println("Connection established");
            PreparedStatement preparedStatement=connection.prepareStatement("insert into course values(?,?,?,?,?);");
            preparedStatement.setInt(1,courseModule.getCourseId());
            preparedStatement.setString(2,courseModule.getCourseName());
            preparedStatement.setString(3,courseModule.getAuthorName());
            long durationInHours = courseModule.getDurationInHours().toHours();
            preparedStatement.setLong(4, durationInHours);
            preparedStatement.setBoolean(5,courseModule.getIsAvailability());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }
        catch(ClassNotFoundException classNotFoundException){
            System.out.println(classNotFoundException.getMessage());
        }
        catch (SQLException sqlException){
            try{
                if(sqlException.getErrorCode()==1062){
                    throw new DuplicateCourseException("PrimaryKey already exists");
                }
            }
            catch (DuplicateCourseException duplicateCourseException){
                System.out.println(duplicateCourseException.getMessage());
            }
            System.out.println(sqlException.getMessage());
        }
    }
    public List<CourseModule> displayCourse(){
        List<CourseModule> courseModuleList = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1/VLSDB","root","mysql");
            System.out.println("Connection established");
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from course");
            while(resultSet.next()){
                int courseId = resultSet.getInt(1);
                String courseName = resultSet.getString(2);
                String authorName = resultSet.getString(3);
                long durationInHours = resultSet.getLong(4);
                Duration duration = Duration.ofHours(durationInHours);
                boolean availability = resultSet.getBoolean(5);
                CourseModule courseModule = new CourseModule(courseId, courseName, authorName, duration, availability);
                courseModuleList.add(courseModule);
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch(ClassNotFoundException classNotFoundException){
            System.out.println(classNotFoundException.getMessage());
        }
        catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return courseModuleList;
    }
    public boolean searchCourse(int courseId){
        boolean courseFound=false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1/VLSDB","root","mysql");
            System.out.println("Connection established");
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from course where courseId="+courseId);
            while(resultSet.next()){
                courseFound=true;
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
                System.out.println(resultSet.getLong(4));
                System.out.println(resultSet.getBoolean(5));
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch(ClassNotFoundException classNotFoundException){
            System.out.println(classNotFoundException.getMessage());
        }
        catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return courseFound;
    }
    public void deleteCourse(int courseId){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1/VLSDB","root","mysql");
            System.out.println("Connection established");
            Statement statement=connection.createStatement();
            statement.executeUpdate("delete from course where courseId="+courseId);
            statement.close();
            connection.close();
        }
        catch(ClassNotFoundException classNotFoundException){
            System.out.println(classNotFoundException.getMessage());
        }
        catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
    }
}
