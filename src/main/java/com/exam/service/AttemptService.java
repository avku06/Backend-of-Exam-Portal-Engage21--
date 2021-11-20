package com.exam.service;

import com.exam.model.Attempt;
import com.exam.model.Question;
import com.exam.model.Quiz;
import com.exam.model.User;
import com.exam.repo.AttemptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AttemptService {
    @Autowired
    private AttemptRepository attemptRepository;

    public Set<Attempt> getAttempts() {
        return new HashSet<>(this.attemptRepository.findAll());
    }

    public Attempt addAttempt(Attempt attempt){
        return this.attemptRepository.save(attempt);
    }

    public Set<Attempt> getUserAttempts(User user){
        return new HashSet<>(this.attemptRepository.findByUser(user));
    }

    public Set<Attempt> getQuizAttempts(Quiz quiz){
        return new HashSet<>(this.attemptRepository.findByQuiz(quiz));
    }

    public Set<Attempt> getUserAndQuizAttempts(User user,Quiz quiz){
        return new HashSet<>(this.attemptRepository.findByUserAndQuiz(user,quiz));
    }
}
