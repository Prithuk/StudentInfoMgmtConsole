/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.demo.entity;

import com.prithu.sim.dto.User;
import com.prithu.sim.repository.MarksRepository;
import com.prithu.sim.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lion
 */
public class UserTest {
    
    public UserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class User.
     */
    @Test
    public void testMaxId() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1L, "Ram", "Hari"));
        userList.add(new User(5L, "Ram", "Hari"));
        userList.add(new User(0L, "Ram", "Hari"));
        
        UserRepository userRepository = new UserRepository();
        userRepository.setUserList(userList);
        assertEquals(5l, userRepository.getMaxID().longValue());
        userList.add(new User(7L, "Ram", "Hari"));
        assertEquals(7l, userRepository.getMaxID().longValue());
        userList.add(new User(8L, "Ram", "Hari"));
        assertEquals(8l, userRepository.getMaxID().longValue());
        
        userList.add(new User(2L, "Ram", "Hari"));
        assertEquals(8l, userRepository.getMaxID().longValue());
        
    }
    
    @Test
    public void test2() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1L, "Ram", "Hari"));
        userList.add(new User(5L, "qw", "Hari"));
        userList.add(new User(0L, "as", "Hari"));
        
        UserRepository userRepository = new UserRepository();
        userRepository.setUserList(userList);
        assertEquals(false, userRepository.isUniqueUserName("Ram"));
        assertEquals(true, userRepository.isUniqueUserName("Hari"));
        assertEquals(false, userRepository.isUniqueUserName("as"));
    }
    
    
    
}
