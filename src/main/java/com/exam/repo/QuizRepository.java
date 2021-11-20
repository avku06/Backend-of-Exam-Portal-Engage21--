package com.exam.repo;

import com.exam.model.Quiz;
import com.exam.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Long> {
    List<Quiz> findBySubject(Subject sub);
    List<Quiz> findByActive(boolean active);
    List<Quiz> findBySubjectAndActive(Subject sub,boolean active);
}
