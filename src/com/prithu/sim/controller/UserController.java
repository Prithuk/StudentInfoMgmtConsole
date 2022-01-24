/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.controller;

import com.prithu.sim.dao.UserDao;
import com.prithu.sim.dao.UserDaoImpl;
import com.prithu.sim.dto.Student;
import com.prithu.sim.dto.User;
import com.prithu.sim.repository.MarksRepository;
import com.prithu.sim.repository.StudentRepository;
import com.prithu.sim.repository.UserRepository;
import static java.lang.System.exit;
import java.util.List;
import java.util.Scanner;

public class UserController {

    static UserRepository userRepository = new UserRepository();
    static Scanner sc = new Scanner(System.in);
    static StudentController studentController = new StudentController();
    static SubjectController subjectController = new SubjectController();
    static StudentRepository studentRepository = new StudentRepository();
    static MarksController marksController = new MarksController();
    static MarksRepository marksRepository = new MarksRepository();
    static UserDao userDao = new UserDaoImpl();

    static String uName = "";
    static long id = 0;

    public static void printMenu(String[] options) {

        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }

    public static void main(String[] args) {

        String[] options = {
            "1-Admin",
            "1.1-Users Register \n 1.2-Search Users \n 1.3-Edit Users \n 1.4-List Users \n 1.5-Exit \n",
            "2-Student",
            "2.1-Add Student \n 2.2-View Student \n 2.3-View Student Class\n",
            "3-Subject",
            "3.1-Add subject",
            "3.2-View Subject",
            "3.3-Add Marks",
            "3.4-View Student Details",
            "3.5-List All student"
        };

        String option = "1.1";

        while (!option.equals("1.6")) {
            printMenu(options);
            try {
                option = sc.next();
                switch (option) {
                    case "1.1":
                        User user = usersRegister();

//                        userRepository.createUser(user);
                        break;
                    case "1.2":
                        System.out.println("Enter User name");
                        String uName = sc.next();
                        searchUsers(uName);
                        break;
                    case "1.3":
                        System.out.println("Enter User name");
                        uName = sc.next();
                        user = editUsers(uName);
                        if (user != null) {
                            userRepository.editUsers(user);
                        }
                        break;
                    case "1.4":
                        listUsers();
                        break;
                    case "2.1":
                        studentController.addStudent();
                        break;
                    case "2.2":
                        studentController.listStudent();
                        break;
                    case "2.3":
                        System.out.println("Enter Student id :");
                        int id = sc.nextInt();
                        System.out.println("Enter student name :");
                        String sname = sc.next();
                        studentController.viewStudentClass(id, sname);
                        break;
                    case "3.1":
                        subjectController.addSubject();
                        break;
                    case "3.2":
                        subjectController.viewSubject();
                        break;
                    case "3.3":
                        marksController.addMarks();
                        break;

                    case "3.4":
                        System.out.println("Enter student id :");
                        Long sid = sc.nextLong();
                        Student student = studentController.findByStudentId(sid);
                        if (student == null) {
                            System.out.println("No Student with that id is found");
                            break;
                        }
                        marksRepository.displayInfo(student);
                        break;
                    case "3.5":
                        studentController.ListAllStudentInfo();
                        break;
                    default:
                        System.out.println("Wrong choice : ");
                        break;

                    case "1.5":
                        exit(0);

                }
            } catch (Exception ex) {
                System.out.println("Please enter an integer value between 1 and " + options.length);
                sc.next();
            }

        }
    }

    public static User usersRegister() {
        System.out.println("Users Registration :");

        User user = new User();

        Long maxId = userRepository.getMaxID();
        user.setId(maxId + 1);
        System.out.println("User id is : " + user.getId());

        System.out.println("Enter User name");
        String uName = sc.next();
        user.setName(uName);

        System.out.print("Enter User password :");
        String uPassword = sc.next();
        user.setPassword(uPassword);

        userDao.saveUserInfo(user);

//        System.out.println(user.toString());
        return user;

    }

    public static void searchUsers(String username) {

        User user = userDao.searchUser(username);
        if (user == null) {
            System.out.println("User not found");
        } else {
            System.out.println(user.toString());
        }
//        for (User user : userRepository.getUserList()) {
//            if (user.getName().equals(username)) {
//                System.out.println(user.toString());
//                return;
//            }
//        }
    }

    public static User editUsers(String username) {
        User u = null;
        for (User user : userRepository.getUserList()) {
            if (user.getName().equals(username)) {
                u = user;
            }
        }
        if (u == null) {
            System.out.println("User not found");
            return null;
        }

        System.out.println("Users update :");

        User user = new User();
        user.setId(u.getId());
        System.out.println("Enter User name");
        String uName = sc.next();
        user.setName(uName);

        System.out.println("Enter User password : ");
        String uPassword = sc.next();
        user.setPassword(uPassword);

        System.out.println(user.toString());
        return user;
    }

    public static void listUsers() {
        List<User> userList = userRepository.getUserList();
        if (userList.isEmpty()) {
            System.out.println("Register at least one user . . ");
        }
        for (User user : userList) {
            user.getId();
            user.getName();
            user.getPassword();
            System.out.println(user.toString());
        }
    }
}

//    public static void main(String[] args) {
//        int choice;
//        System.out.println("\n 1-Admin \n 2-Student \n3-Exit");
//        choice = sc.nextInt();
//
//        switch (choice) {
//            case 1:
//                char ch;
//                System.out.println("Admin Registration");
//                System.out.println("A-  Users Register \n B- Search Users \n C- Edit Users \n D- List Users ");
//                ch = sc.next().charAt(0);
//                switch (ch) {
//                    case 'A':
//                        User user = usersRegister();
//                        userRepository.createUser(user);
//                        break;
//                    case 'B':
//                        System.out.println("Enter User name");
//                        String uName = sc.next();
//                        searchUsers(uName);
//                        break;
//                    case 'C':
//                        System.out.println("Enter User name");
//                        uName = sc.next();
//                        user = editUsers(uName);
//                        if (user != null) {
//                            userRepository.editUsers(user);
//                        }
//                        break;
//                    case 'D':
//                        listUsers();
//                        break;
//
//                    default:
//                        System.out.println("Wrong choice");
//                }
//                break;
//            case 2:
//                char ch1;
//                System.out.println("Student Registration :");
//                System.out.println("a-Add Student \n b-View Student");
//                ch1 = sc.next().charAt(0);
//                switch (ch1) {
//                    case 'a':
//                        studentController.addStudent();
//                        break;
//                    case 'b':
//                        studentController.listStudent();
//                        break;
//                    default:
//                        System.out.println("Wrong choice : ");
//                }
//                break;
//
//            case 3:
//                exit(0);
//        }
//    }
