/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.repository;

import com.prithu.sim.dto.User;
import com.prithu.sim.util.DbUtil;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.List;

public class UserRepository {

    PreparedStatement ps = null;
    private List<User> userList = new ArrayList<>();

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public UserRepository() {
        this.userList = new ArrayList<>();
    }

    public void createUser(User user) {
        for (User u : userList) {
            if (u.getName().equals(user.getName())) {
                System.out.println("Already registered. . ");
                return;
            }
        }
        userList.add(user);

    }

    public void editUsers(User user) {
        for (User u : userList) {
            if (u.getId().equals(user.getId())) {
                u.setId(user.getId());
                u.setName(user.getName());
                u.setPassword(user.getPassword());
                return;
            }
        }
    }

    public Long getMaxID() {
        Long max = 0L;
        try {
            String sql = "select max(id) from user_info";
            ps = DbUtil.getConnection().prepareStatement(sql);
            ResultSet rs = (ResultSet) ps.executeQuery(sql);

            if (rs.next()) {
                max = rs.getLong(1);
            }
        } catch (Exception e) {
            System.out.println("Exception" + e.getMessage());
        }
        return max;

    }

    public boolean isUniqueUserName(String username) {
        for (User u : userList) {
            if (u.getName().equals(username)) {
                return false;
            }
        }
        return true;
    }
}
