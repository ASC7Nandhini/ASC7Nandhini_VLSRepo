package com.asc.ui;

import java.sql.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        boolean login=false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1/LoginPage","root","mysql");
            Statement statement=connection.createStatement();
            System.out.println("Enter UserName: ");
            String userName=sc.nextLine();
            System.out.println("Enter Password: ");
            String password=sc.nextLine();
            ResultSet resultSet=statement.executeQuery("select * from credentials where username=\'"+userName+"\' and password=\'"+password+"\'");
            if(resultSet.next()) {
                login=true;
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (ClassNotFoundException classNotFoundException) {
            System.out.println(classNotFoundException.getMessage());;
        }
        catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());;
        }
        if(login){
            System.out.println("Login Successful");
            System.out.println("Welcome to Virtual Learning System");
            Menu menu=new Menu();
            menu.displayMenu();
            System.out.println("Enter your Choice: ");
            int choice=menu.getChoice();
            while (choice>0 && choice<5){
                switch (choice){
                    case 1:
                        menu.addCourse(menu.getCourseModule());
                        break;
                    case 2:
                        menu.displayCourse();
                        break;
                    case 3:
                        menu.searchCourse();
                        break;
                    case 4:
                        menu.deleteCourse();
                        break;
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
                menu.displayMenu();
                System.out.println("Enter your Choice: ");
                choice=menu.getChoice();
            }
        }
        else {
            System.out.println("Login Unsuccessful");
        }
    }
}
