/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.demo.repository;

import com.prithu.demo.entity.User;
import java.util.ArrayList;

import java.util.List;

public class UserRepository {

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
        for (User u : userList) {
            if (u.getId() > max) {
                max = u.getId();
            }
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
