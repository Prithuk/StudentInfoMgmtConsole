/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.controller;

import com.prithu.sim.dao.SubjectDao;
import com.prithu.sim.dao.SubjectDaoImpl;
import com.prithu.sim.dto.Subject;
import com.prithu.sim.repository.SubjectRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubjectController {

    Scanner sc = new Scanner(System.in);
    Subject subject = new Subject();
    static SubjectRepository subjectRepository = new SubjectRepository();
    static SubjectDao subjectDao = new SubjectDaoImpl();

    public void addSubject() {

        System.out.print("Please enter the number of Subjects you want to enter: ");
        int subNum = sc.nextInt();
        for (int i = 0; i < subNum; i++) {
            Subject subject = new Subject();
            String name = sc.next();
            subject.setSubName(name);
            subject.setId(subjectRepository.getSubmaxId() + 1);

            subjectDao.addSubject(subject);

//            subjectRepository.getSubjectList().add(subject);
//            System.out.println(subject.toString());
        }

    }

    public void viewSubject() {
        List<Subject> subjectList = subjectDao.viewSubject();
        if (subjectList.isEmpty()) {
            System.out.println("Register at least one subject : ");
        } else {

            System.out.println(subjectList.toString());
        }
    }

//        List<Subject> subjectList = subjectRepository.getSubjectList();
//
//        if (subjectList.isEmpty()) {
//            System.out.println("Register at least one subject : ");
//        }
//        for (Subject subject : subjectRepository.getSubjectList()) {
//            subject.getSubName();
//            System.out.println(subject.toString());
//        }
//    }
}
