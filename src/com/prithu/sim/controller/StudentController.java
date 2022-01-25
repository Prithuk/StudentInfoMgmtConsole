/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.controller;

import com.prithu.sim.dao.StudentDao;
import com.prithu.sim.dao.StudentDaoImpl;
import com.prithu.sim.dto.Student;
import com.prithu.sim.repository.MarksRepository;
import com.prithu.sim.repository.StudentRepository;
import com.prithu.sim.util.DbUtil;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;
import java.sql.ResultSet;

public class StudentController {

    static MarksRepository marksRepository = new MarksRepository();
    static Scanner sc = new Scanner(System.in);
    static StudentRepository studentRepository = new StudentRepository();
    static StudentDao studentDao = new StudentDaoImpl();
    PreparedStatement ps = null;

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

        studentDao.saveStudentInfo(student);

//        studentRepository.getStudentList().add(student);
//        System.out.println(student.toString());
        return student;

    }

    public void listStudent() {

        List<Student> studentList = studentDao.getAllStudentInfo();
        if (studentList.isEmpty()) {
            System.out.println("Register at least one student . . ");

        } else {

            System.out.println(studentList.toString());
        }
    }

    public void viewStudentClass(int id, String username) {
        String sql = "select student_class from student_info where student_id=? AND student_name=?";
        try {
            ps = DbUtil.getConnection().prepareStatement(sql);
            ps.setLong(1, id);
            ps.setString(2, username);
            ResultSet rs = ps.executeQuery();
            int student = 0;
            while (rs.next()) {
                student = rs.getInt(1);
            }
            if (student == 0) {
                System.out.println("Student class not found");
            } else {
                System.out.println("Student Class is : " + student);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

//        for (Student student : studentRepository.getStudentList()) {
//            if (student.getsID() == id && student.getsName().equals(username)) {
//                System.out.println("Student class is : " + student.getsClass());
//                return;
//            }
//        }
//        System.out.println("Class not found");
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
