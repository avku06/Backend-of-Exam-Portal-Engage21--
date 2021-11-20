package com.exam.repo;

import com.exam.model.Attempt;
import com.exam.model.Quiz;
import com.exam.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AttemptRepository extends JpaRepository<Attempt,Long> {
    Set<Attempt> findByUser(User user);

    Set<Attempt> findByQuiz(Quiz quiz);

    Set<Attempt> findByUserAndQuiz(User user, Quiz quiz);
}
