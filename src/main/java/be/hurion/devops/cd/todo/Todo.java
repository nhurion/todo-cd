package be.hurion.devops.cd.todo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;
import java.time.LocalDate;

@Entity
public class Todo {

    @Id
    private BigInteger id;
    private String title;
    private boolean completed;
    @Column( name = "created_date")
    private LocalDate createdDate;
    @Column( name = "completed_date")
    private LocalDate completedDate;

    public Todo() {
        //JPA
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(LocalDate completedDate) {
        this.completedDate = completedDate;
    }

    public Todo complete(){
        this.completed = true;
        this.completedDate = LocalDate.now();
        return this;
    }
}
