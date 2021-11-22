package com.exam.service;

import com.exam.helper.SubjectFoundException;
import com.exam.model.Subject;
import com.exam.repo.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public Subject addSubject(Subject sub) throws Exception {
        Subject local = this.subjectRepository.findByName(sub.getName());
        if (local != null) {
//            System.out.println("Subject is already there !!");
            throw new SubjectFoundException();
        }
        else {
            local = this.subjectRepository.save(sub);
        }
        return local;
    }

    public Subject updateSubject(Subject sub) {
        return this.subjectRepository.save(sub);
    }

    public Set<Subject> getSubjects() {
        return new LinkedHashSet<>(this.subjectRepository.findAll());
    }

    public Subject getSubject(Long subId) {
        return this.subjectRepository.findById(subId).get();
    }

    public void deleteSubject(Long subId) {
        Subject sub = new Subject();
        sub.setCid(subId);
        this.subjectRepository.delete(sub);
    }

    public Subject getSubjectBySubjectName(String name){
        return this.subjectRepository.findByName(name);
    }

}
