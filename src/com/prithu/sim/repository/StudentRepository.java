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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lion
 */
public class StudentRepository {

    PreparedStatement ps = null;

    public List<Student> getStudentList() {
        List<Student> studentList = new ArrayList<>();
        String sql = "select * from student_info";
        try {
            ps = DbUtil.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Student student = new Student();
                student.setsID(rs.getLong(1));
                student.setsName(rs.getString(2));
                student.setsClass(rs.getInt(3));
                student.setsEmail(rs.getString(4));
                student.setsPhone(rs.getLong(5));
                studentList.add(student);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return studentList;
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
