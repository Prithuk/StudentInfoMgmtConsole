/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.repository;

import com.prithu.sim.dto.Student;
import com.prithu.sim.dto.Subject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lion
 */
public class SubjectRepository {

    private List<Subject> subjectList = new ArrayList<>();

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public SubjectRepository() {

    }
    
    
    public Long getSubmaxId() {
        Long max = 10L;
        for (Subject sub : subjectList) {
            if (sub.getId() > max) {
                max = sub.getId();
            }
        }
        return max;

    }
    
    
    

}
