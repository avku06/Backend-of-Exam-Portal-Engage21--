package com.exam.controller;

import com.exam.helper.SubjectFoundException;
import com.exam.helper.UserFoundException;
import com.exam.model.Subject;
import com.exam.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subject")
@CrossOrigin("*")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    //add category
    @PostMapping("/")
    public Subject addSubject (@RequestBody Subject sub) throws Exception {
        return this.subjectService.addSubject(sub);
    }

    //get category
    @GetMapping("/{subjectId}")
    public ResponseEntity<Subject> getSubject(@PathVariable("subjectId") Long subId) {
        return ResponseEntity.ok(this.subjectService.getSubject(subId));
    }

    //get all categories
    @GetMapping("/")
    public ResponseEntity<?> getSubjects() {
        return ResponseEntity.ok(this.subjectService.getSubjects());
    }

    @GetMapping("/{subjname}")
    public ResponseEntity<?> getSubjectBySubjectName(@PathVariable String name) {
        return ResponseEntity.ok(this.subjectService.getSubjects());
    }

    //update category
    @PutMapping("/")
    public ResponseEntity<?> updateSubject(@RequestBody Subject sub) {
        return ResponseEntity.ok(this.subjectService.updateSubject(sub));
    }

    //delete category
    @DeleteMapping("/{subId}")
    public void deleteSubject(@PathVariable("subId") Long subId) {
        this.subjectService.deleteSubject(subId);
    }


    @ExceptionHandler(SubjectFoundException.class)
    public ResponseEntity<?> exceptionHandler(SubjectFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }
}
