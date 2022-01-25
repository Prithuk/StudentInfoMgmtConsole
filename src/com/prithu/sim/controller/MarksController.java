/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.controller;

import com.prithu.sim.dao.MarksDao;
import com.prithu.sim.dao.MarksDaoImpl;

import com.prithu.sim.dto.Marks;
import com.prithu.sim.repository.MarksRepository;
import java.util.Scanner;

/**
 *
 * @author lion
 */
public class MarksController {

    MarksDao marksDao = new MarksDaoImpl();
    Scanner sc = new Scanner(System.in);
    Marks marks = new Marks();
    //static StudentRepository studentRepository = new StudentRepository();

//    SubjectRepository subjectRepository1;
    MarksRepository marksRepository = new MarksRepository();
//
//    public MarksController() {
//        subjectRepository1 = new SubjectRepository();
//
//    }
//
//    public SubjectRepository getSubjectRepository1() {
//        return subjectRepository1;
//    }
//
//    public void setSubjectRepository1(SubjectRepository subjectRepository1) {
//        this.subjectRepository1 = subjectRepository1;
//    }

    public void addMarks() {
        System.out.println("Enter student id");
        Long sid = sc.nextLong();
        marks.setStudentId(sid);
        System.out.println("Enter Subject id");
        Long subId = sc.nextLong();
        marks.setSubjectId(subId);
        System.out.println("Enter Marks for Subject");
        float submarks = sc.nextFloat();
        marks.setSubMarks(submarks);
        marksDao.addMarks(marks);

//        for (Student student : studentRepository.getStudentList()) {
//            System.out.println("Student name is :" + student.getsName());
//
//            for (Subject subject : subjectRepository.getSubjectList()) {
//                System.out.println("Enter marks for subject :" + subject.getSubName());
//                float submarks = sc.nextFloat();
//                Marks marks = new Marks(student.getsID(), subject.getId(), submarks);
//                
//                marksRepository.getMarkList().add(marks);
    }
}
