/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.dao;

import com.prithu.sim.dto.Subject;
import com.prithu.sim.util.DbUtil;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lion
 */
public class SubjectDaoImpl implements SubjectDao {

    PreparedStatement ps = null;

    @Override
    public void addSubject(Subject subject) {
        String sql = "Insert into Subject(id, name) values(?,?) ";
        try {
            ps = DbUtil.getConnection().prepareStatement(sql);
            ps.setLong(1, subject.getId());
            ps.setString(2, subject.getSubName());
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void viewSubject() {
    }

    @Override
    public void AddMarks() {
    }

}
