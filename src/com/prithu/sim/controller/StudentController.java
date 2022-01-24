/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.controller;

import com.prithu.sim.dto.Student;
import com.prithu.sim.repository.MarksRepository;
import com.prithu.sim.repository.StudentRepository;
import java.util.List;
import java.util.Scanner;

public class StudentController {

    static MarksRepository marksRepository = new MarksRepository();
    static Scanner sc = new Scanner(System.in);
    static StudentRepository studentRepository = new StudentRepository();

    public Student addStudent() {
        Student student = new Student();

        System.out.println("Student Registration : ");

        student.setsID(studentRepository.getSmaxId() + 1);

        System.out.println("Enter Student Name : ");
        String sname = sc.next();
        student.setsName(sname);

        System.out.println("Student ," + sname + "id is : " + student.getsID());

        System.out.println("Enter Student Email : ");
        String sEmail = sc.next();
        student.setsEmail(sEmail);

        System.out.println("Enter Student Phone no : ");
        long sPhone = sc.nextLong();
        student.setsPhone(sPhone);

        System.out.println("Enter student Class");
        int sclass = sc.nextInt();
        student.setsClass(sclass);

        studentRepository.getStudentList().add(student);

        System.out.println(student.toString());
        return student;

    }

    public void listStudent() {
        List<Student> studentList = studentRepository.getStudentList();
        if (studentList.isEmpty()) {
            System.out.println("Register at least one student . . ");
            return;
        }
        for (Student student : studentList) {
            student.getsName();
            student.getsEmail();
            student.getsPhone();
            System.out.println(student.toString());
        }
    }

    public void viewStudentClass(int id, String username) {

        for (Student student : studentRepository.getStudentList()) {
            if (student.getsID() == id && student.getsName().equals(username)) {
                System.out.println("Student class is : " + student.getsClass());
                return;
            }
        }
        System.out.println("Class not found");
    }

    public void ListAllStudentInfo() {
        List<Student> studentList = studentRepository.getStudentList();
        for (Student student : studentList) {
            marksRepository.displayInfo(student);
        }
    }

    public Student findByStudentId(Long id) {
        for (Student student : studentRepository.getStudentList()) {

            if (student.getsID() == id) {
                return student;
            }
        }
        return null;
    }
}
