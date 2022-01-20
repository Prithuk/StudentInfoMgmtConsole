///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.prithu.controller;
//
//import com.prithu.demo.entity.Marks;
//import com.prithu.demo.entity.Student;
//import com.prithu.demo.repository.MarksRepository;
//import com.prithu.demo.repository.SubjectRepository;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * @author lion
// */
//public class ResultSet {
//
//    static MarksController marksController = new MarksController();
//    static MarksRepository marksRepository = new MarksRepository();
//    static SubjectRepository subjectRepository = new SubjectRepository();
//    List<MarksRepository> marksRepositorys = new ArrayList<>();
//
//
//    public void displayInfo(Student student) {
//        for (Marks marks : marksRepository.getMarkList()) {
//            System.out.println("Result:" + student.getsName());
//            System.out.println("Subject" + "\t" + "Marks");
//            if (marks.getStudentId().equals(student.getsID())) {
//                System.out.println(marks.getSubjectId() + "\t" + marks.getSubMarks());
//                System.out.println("total marks :" + getTotalMarks(student));
//                System.out.println("Divison is :"+ getDivison(student));
//                System.out.println("Percentage is :"+getPercentage(student));
//            }
//        }
//    }
//
//    public String getDivison(Student student) {
//
//        float percent = getPercentage(student);
//
//        if (percent >= 80 && percent < 100) {
//            return "Distinction";
//        } else if (percent >= 60 && percent < 80) {
//            return "First Divison";
//        } else if (percent >= 45 && percent < 60) {
//            return "Second Divison";
//        } else if (percent >= 40 && percent < 45) {
//            return "Third Divison";
//        } else {
//            return "Failed";
//        }
//    }
//
//    public float getTotalMarks(Student student) {
//        float total = 0;
//        for (Marks marks : marksRepository.getMarkList()) {
//            if (marks.getStudentId().equals(student.getsID())) {
//                total = total + marks.getSubMarks();
//            }
//        }
//        System.out.println("Total subject is : " + subjectRepository.getSubjectList().size());
//        return total;
//
//    }
//
//    public float getPercentage(Student student) {
//        float totalMarks = getTotalMarks(student);
//        float percentage = (totalMarks / (subjectRepository.getSubjectList().size() * 100)) * 100;
//        return percentage;
//    }
//
//}
