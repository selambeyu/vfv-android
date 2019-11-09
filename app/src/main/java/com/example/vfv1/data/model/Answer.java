package com.example.vfv1.data.model;

import java.util.Date;

public class Answer {

    public String answer;
    public String answeredBy;
    public String questionId;
    public Date createdAt;
    public Date modified;

    public Answer(){

    }

    public Answer(String answer, String answeredBy, String questionId, Date createdAt, Date modified) {
        this.answer = answer;
        this.answeredBy = answeredBy;
        this.questionId = questionId;
        this.createdAt = createdAt;
        this.modified = modified;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnsweredBy() {
        return answeredBy;
    }

    public void setAnsweredBy(String answeredBy) {
        this.answeredBy = answeredBy;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
