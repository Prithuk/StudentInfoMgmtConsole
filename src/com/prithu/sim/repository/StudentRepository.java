/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.repository;

import java.sql.ResultSet;
import com.prithu.sim.dto.Student;
import com.prithu.sim.util.DbUtil;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lion
 */
public class StudentRepository {

    PreparedStatement ps = null;
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
        String sql = "select max(student_id) from student_info";
        try {
            ps = DbUtil.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                max = rs.getLong(1);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
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
