package com.visa.oi.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by caware on 2/28/2017.
 */
@Entity
@Table(name="ISSUE")
public class Issue {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="ISSUE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int issueId;

    @Column(name = "Description")
    String description;

    @Column(name = "Creation_Date")
    Timestamp creationDate;

    public Issue(){
        super();
    }

    public Issue(int id, String desc) {
        Timestamp cDate = new Timestamp(System.currentTimeMillis());
        this.issueId = id;
        this.description = desc;
        this.creationDate = cDate;
    }

    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "issueId=" + issueId +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
