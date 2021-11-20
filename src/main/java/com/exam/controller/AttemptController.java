package com.exam.controller;

import com.exam.model.*;
import com.exam.service.AttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/attempts")
public class AttemptController {

    @Autowired
    private AttemptService attemptService;

    @PostMapping("/")
    public ResponseEntity<?> addAttempt(@RequestBody Attempt attempt) {
        return ResponseEntity.ok(this.attemptService.addAttempt(attempt));
    }

    //get all attempts
    @GetMapping("/")
    public ResponseEntity<?> getAttempts() {
        return ResponseEntity.ok(this.attemptService.getAttempts());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUserAttempts(@PathVariable("userId") Long userId) {
        User user=new User();
        user.setId(userId);
        Set<Attempt> user_attempts  = this.attemptService.getUserAttempts(user);
        return ResponseEntity.ok(user_attempts);
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<?> getQuizAttempts(@PathVariable("quizId") Long quizId) {
        Quiz quiz=new Quiz();
        quiz.setqId(quizId);
        Set<Attempt> quiz_attempts  = this.attemptService.getQuizAttempts(quiz);
        return ResponseEntity.ok(quiz_attempts);
    }

    @GetMapping("/user/{userId}/quiz/{quizId}")
    public ResponseEntity<?> getQuizAttempts(@PathVariable("quizId") Long quizId, @PathVariable("userId") Long userId) {
        Quiz quiz=new Quiz();
        quiz.setqId(quizId);
        User user=new User();
        user.setId(userId);
        Set<Attempt> quiz_user_attempts  = this.attemptService.getUserAndQuizAttempts(user,quiz);
        return ResponseEntity.ok(quiz_user_attempts);
    }
}
