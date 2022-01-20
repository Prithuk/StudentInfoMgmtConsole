///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.prithu.controller;
//
//import com.prithu.demo.entity.User;
//import com.prithu.demo.repository.UserRepository;
//import static java.lang.System.exit;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
///**
// * @author lion
// */
//public class TestController {
//
//    static UserRepository userRepository = new UserRepository();
//    static Scanner sc = new Scanner(System.in);
//    static List<User> userList = new ArrayList<>();
//    static StudentController studentController = new StudentController();
//
//    static String uName = "";
//    static long id = 0;
//
//    public static void printMenu(String[] options) {
//        for (String option : options) {
//            System.out.println(option);
//        }
//        System.out.print("Choose your option : ");
//    }
//
//    public static void printMenu1(String[] options1) {
//        for (String option1 : options1) {
//            System.out.println(option1);
//        }
//        System.out.print("Choose your option : ");
//    }
//
//    public static void printMenu2(String[] options2) {
//        for (String option2 : options2) {
//            System.out.println(option2);
//        }
//        System.out.print("Choose your option : ");
//    }
//
//    public static void main(String[] args) {
//
//        String[] options = {"1-Admin", "2-Student", "3-Exit"};
//        String[] options1 = {"10-  Users Register", "11- Search Users", "12- Edit Users", "13- List Users ", "14-Exit"};
//        String[] options2 = {"20-Add Student", "21-View Student", "22-Exit"};
//
////        int choice;
////        System.out.println("\n 1-Admin \n 2-Student \n3-Exit");
////        choice = sc.nextInt();
//        int option = 1;
//
//        while (option != 4) {
//            printMenu(options);
//            try {
//                option = sc.nextInt();
//                switch (option) {
//                    case 1:
//                    
//                        System.out.println("Admin Registration");
////                        System.out.println("A-  Users Register \n B- Search Users \n C- Edit Users \n D- List Users ");
//                        int option1 = 10;
//                        while (option1!=15) {
//                            printMenu1(options1);
//                            try {
//                                option1 = sc.nextInt();
//                                switch (option1) {
//
//                                    case 10:
//                                        User user = usersRegister();
//                                        userRepository.createUser(user);
//                                        break;
//                                    case 11:
//                                        System.out.println("Enter User name");
//                                        String uName = sc.next();
//                                        searchUsers(uName);
//                                        break;
//                                    case 12:
//                                        System.out.println("Enter User name");
//                                        uName = sc.next();
//                                        user = editUsers(uName);
//                                        if (user != null) {
//                                            userRepository.editUsers(user);
//                                        }
//                                        break;
//                                    case 13:
//                                        listUsers();
//                                        break;
//                                    case 14:
//                                        exit(0);
//
//                                }
//                                break;
//                            } catch (Exception ex) {
//                                System.out.println("Please enter an integer value between 1 and " + options1.length);
//                                sc.next();
//                            }
//                        }
//                    case 2:
//
//                        System.out.println("Student Registration :");
//                        int option2 = 20;
//                        while (option2!=24) {
//                            printMenu2(options2);
//                            try {
//                                option2 = sc.nextInt();
//                                switch (option2) {
//                                    case 20:
//                                        studentController.addStudent();
//                                        break;
//                                    case 21:
//                                        studentController.listStudent();
//                                        break;
//                                    case 22:
//                                        exit(0);
//                                }
//                                break;
//                            } catch (Exception ex) {
//                                System.out.println("Please enter an integer value between 1 and " + options2.length);
//                                sc.next();
//                            }
//                        }
//
//                    case 3:
//                        exit(0);
//                }
//            } catch (Exception ex) {
//                System.out.println("Please enter an integer value between 1 and " + options.length);
//                sc.next();
//            }
//
//        }
//    }
//
//    public static User usersRegister() {
//        System.out.println("Users Registration :");
//
//        User user = new User();
//
//        user.setId(userRepository.getMaxID() + 1);
//        System.out.println("User id is : " + user.getId());
//
//        System.out.println("Enter User name");
//        String uName = sc.next();
//        user.setName(uName);
//
//        System.out.print("Enter User password :");
//        String uPassword = sc.next();
//        user.setPassword(uPassword);
//        userList.add(user);
//
//        System.out.println(user.toString());
//        return user;
//
//    }
//
//    public static void searchUsers(String username) {
//        for (User user : userList) {
//            if (user.getName().equals(username)) {
//                System.out.println(user.toString());
//                return;
//            }
//        }
//        System.out.println("User not found");
//    }
//
//    public static User editUsers(String username) {
//        User u = null;
//        for (User user : userRepository.getUserList()) {
//            if (user.getName().equals(username)) {
//                u = user;
//            }
//        }
//        if (u == null) {
//            System.out.println("User not found");
//            return null;
//        }
//
//        System.out.println("Users update :");
//
//        User user = new User();
//        user.setId(u.getId());
//        System.out.println("Enter User name");
//        String uName = sc.next();
//        user.setName(uName);
//
//        System.out.println("Enter User password : ");
//        String uPassword = sc.next();
//        user.setPassword(uPassword);
//
//        userList.add(user);
//
//        System.out.println(user.toString());
//        return user;
//    }
//
//    public static void listUsers() {
//        List<User> userList = userRepository.getUserList();
//        if (userList.isEmpty()) {
//            System.out.println("Register at least one user . . ");
//        }
//        for (User user : userList) {
//            user.getId();
//            user.getName();
//            user.getPassword();
//            System.out.println(user.toString());
//        }
//    }
//
//}
