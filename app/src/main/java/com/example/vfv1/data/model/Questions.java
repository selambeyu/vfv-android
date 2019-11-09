package com.example.vfv1.data.model;

import java.util.Date;

public class Questions {

    public String question;
    public String askedBy;
    public Date createAt;
    public Date modified;

    public Questions(){

    }

    public Questions(String question, String askedBy, Date createAt, Date modified) {
        this.question = question;
        this.askedBy = askedBy;
        this.createAt = createAt;
        this.modified = modified;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAskedBy() {
        return askedBy;
    }

    public void setAskedBy(String askedBy) {
        this.askedBy = askedBy;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
