/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.repository;

import com.prithu.sim.dto.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lion
 */
public class StudentRepository {

    private List<Student> studentList = new ArrayList<>();

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public StudentRepository() {
        this.studentList = new ArrayList<>();

    }

    public Long getSmaxId() {
        Long max = 100L;
        for (Student s : studentList) {
            if (s.getsID() > max) {
                max = s.getsID();
            }
        }
        return max;

    }

//    public Student findByStudentId(Long id) {
//        for (Student student : studentList) {
//
//            if (student.getsID() == id) {
//                return student;
//            }
//        }
//        return null;
//    }
}
