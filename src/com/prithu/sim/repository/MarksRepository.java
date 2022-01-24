/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.repository;

import com.prithu.sim.controller.MarksController;
import com.prithu.sim.dto.Marks;
import com.prithu.sim.dto.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lion
 */
public class MarksRepository {

    private List<Marks> markList = new ArrayList<>();

    public List<Marks> getMarkList() {
        return markList;
    }

    public void setMarkList(List<Marks> markList) {
        this.markList = markList;
    }

    static MarksController marksController = new MarksController();

    SubjectRepository subjectRepository;
    List<MarksRepository> marksRepositorys = new ArrayList<>();

    public MarksRepository() {
        subjectRepository = new SubjectRepository();

    }

    public SubjectRepository getSubjectRepository() {
        return subjectRepository;
    }

    public void setSubjectRepository(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public void displayInfo(Student student) {
        for (Marks marks : getMarkList()) {
            System.out.println("Result:" + student.getsName());
            System.out.println("Subject" + "\t" + "Marks");
            if (marks.getStudentId().equals(student.getsID())) {
                System.out.println(marks.getSubjectId() + "\t" + marks.getSubMarks());
                System.out.println("total marks :" + getTotalMarks(student));
                System.out.println("Divison is :" + getDivison(student));
                System.out.println("Percentage is :" + getPercentage(student));
            }
        }
    }

    public String getDivison(Student student) {

        float percent = getPercentage(student);

        if (percent >= 80 && percent < 100) {
            return "Distinction";
        } else if (percent >= 60 && percent < 80) {
            return "First Divison";
        } else if (percent >= 45 && percent < 60) {
            return "Second Divison";
        } else if (percent >= 40 && percent < 45) {
            return "Third Divison";
        } else {
            return "Failed";
        }
    }

    public float getTotalMarks(Student student) {
        float total = 0;
        for (Marks marks : getMarkList()) {
            if (marks.getStudentId().equals(student.getsID())) {
                total = total + marks.getSubMarks();
            }
        }
        System.out.println("total marks is :" + total);
        return total;

    }

    public List<Long> getUnqSubjectsForStd(Student student, List<Marks> marksList) {
        List<Long> subjectList = new ArrayList<>();
        for (Marks m : marksList) {
            if (m.getStudentId().equals(student.getsID()) && !subjectList.contains(m.getSubjectId())) {
                subjectList.add(m.getSubjectId());
            }
        }
        return subjectList;
    }

    public List<Long> getUnqStudents(List<Marks> marksList) {
        List<Long> stds = new ArrayList<>();
        for (Marks m : marksList) {
            if (!stds.contains(m.getStudentId())) {
                stds.add(m.getStudentId());
            }
        }
        return stds;
    }
    //key, value

    public Map<Long, List<Long>> getStudentSubjectsMap(List<Marks> marks) {
        Map<Long, List<Long>> studentSubMap = new HashMap<>();
        List<Long> students = getUnqStudents(marks);
        for (Long std : students) {
            Student student = new Student();
            student.setsID(std);
            studentSubMap.put(std, getUnqSubjectsForStd(student, marks));
        }
        return studentSubMap;
    }

    public float getPercentage(Student student) {
        float totalMarks = getTotalMarks(student);

        //  float totalSubject = getUnqSubjectsForStd(student, getMarkList()).size();
        List<Long> subList = getStudentSubjectsMap(getMarkList()).getOrDefault(student.getsID(), new ArrayList<>());
        float totalSubject = subList.size();
        float percentage = (totalMarks / (totalSubject * 100)) * 100;
        System.out.println("Percentage is : " + percentage);
        return percentage;
    }
}