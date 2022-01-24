/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.controller;

import static com.prithu.sim.controller.SubjectController.subjectRepository;
import static com.prithu.sim.controller.StudentController.studentRepository;

import com.prithu.sim.dto.Marks;
import com.prithu.sim.dto.Student;
import com.prithu.sim.dto.Subject;
import com.prithu.sim.repository.MarksRepository;
import java.util.Scanner;

/**
 *
 * @author lion
 */
public class MarksController {

    Scanner sc = new Scanner(System.in);
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
        for (Student student : studentRepository.getStudentList()) {
            System.out.println("Student name is :" + student.getsName());

            for (Subject subject : subjectRepository.getSubjectList()) {
                System.out.println("Enter marks for subject :" + subject.getSubName());
                float submarks = sc.nextFloat();
                Marks marks = new Marks(student.getsID(), subject.getId(), submarks);
                marksRepository.getMarkList().add(marks);
            }
        }
    }
}
