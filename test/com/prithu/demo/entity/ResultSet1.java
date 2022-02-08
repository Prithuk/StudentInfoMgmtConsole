///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.prithu.demo.entity;
//
//import com.prithu.sim.dto.Marks;
//import com.prithu.sim.dto.Student;
//import com.prithu.sim.repository.MarksRepository;
//import com.prithu.sim.repository.SubjectRepository;
//import java.util.ArrayList;
//import java.util.List;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author lion
// */
//public class ResultSet1 {
//
//    public ResultSet1() {
//    }
//
//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @Before
//    public void setUp() {
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    @Test
//    public void testPercentage() {
//
//        List<Marks> marksList = new ArrayList<>();
//
//        
//        marksList.add(new Marks(100L, 11L, (float) 40.5));
//        marksList.add(new Marks(100L, 13L, (float) 50.5));
//        marksList.add(new Marks(100L, 12L, (float) 30.5));
//        marksList.add(new Marks(100L, 14L, (float) 95.5));
//        marksList.add(new Marks(101L, 11L, (float) 90.5));
//        marksList.add(new Marks(101L, 13L, (float) 80.5));
//        marksList.add(new Marks(101L, 12L, (float) 70.5));
//        marksList.add(new Marks(101L, 14L, (float) 60.5));
//        MarksRepository marksRepository = new MarksRepository();
//
////        marksRepository.setMarkList(marksList);
////        Student student = new Student(100L, "Ramu", "Kapan", "P@gmail.com", 984391527L, 10);
////        Student student1 = new Student(101L, "Ram", "Kapan", "P@gmail.com", 984391527L, 10);
////
////        assertEquals((float) 54.25, marksRepository.getPercentage(student), 0);
////        assertEquals((float) 75.5, marksRepository.getPercentage(student1), 0);
////    }
////    
//
//    @Test
//    public void testTotalMarks() {
//
//        List<Marks> marksList = new ArrayList<>();
//        marksList.add(new Marks(100L, 11L, (float) 40.5));
//        marksList.add(new Marks(100L, 13L, (float) 50.5));
//        marksList.add(new Marks(100L, 12L, (float) 30.5));
//        marksList.add(new Marks(100L, 14L, (float) 95.5));
//        marksList.add(new Marks(101L, 11L, (float) 90.5));
//        marksList.add(new Marks(101L, 13L, (float) 80.5));
//        marksList.add(new Marks(101L, 12L, (float) 70.5));
//        marksList.add(new Marks(101L, 14L, (float) 60.5));
//        MarksRepository marksRepository = new MarksRepository();
//
//        marksRepository.setMarkList(marksList);
//        Student student = new Student(100L, "Ram", "Kapan", "P@gmail.com", 984391527L, 10);
//        Student student1 = new Student(101L, "Shyam", "Kapan", "P@gmail.com", 984391527L, 10);
//        assertEquals((float) 217.0, marksRepository.getTotalMarks(student), 0);
//        assertEquals((float) 302.0, marksRepository.getTotalMarks(student1), 0);
//
//    }
//
//}
