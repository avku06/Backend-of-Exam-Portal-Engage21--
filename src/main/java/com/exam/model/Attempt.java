package com.exam.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "attempts")
public class Attempt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long attemptId;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Quiz quiz;

    private String marksGot;

    private String correct_ques;

    private String attempted_ques;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    public Attempt() {
    }

    public Attempt( User user, Quiz quiz, String marksGot, String correctAnswers, String attempted) {
        this.user = user;
        this.quiz = quiz;
        this.marksGot = marksGot;
        this.correct_ques = correctAnswers;
        this.attempted_ques = attempted;
    }

    public Long getAttemptId() {
        return attemptId;
    }

    public void setAttemptId(Long attemptId) {
        this.attemptId = attemptId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public String getMarksGot() {
        return marksGot;
    }

    public void setMarksGot(String marksGot) {
        this.marksGot = marksGot;
    }


    public String getCorrect_ques() {
        return correct_ques;
    }

    public void setCorrect_ques(String correct_ques) {
        this.correct_ques = correct_ques;
    }

    public String getAttempted_ques() {
        return attempted_ques;
    }

    public void setAttempted_ques(String attempted_ques) {
        this.attempted_ques = attempted_ques;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }
}