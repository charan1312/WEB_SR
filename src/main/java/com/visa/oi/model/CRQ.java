package com.visa.oi.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by caware on 2/28/2017.
 */
@Entity
@Table(name="CRQ")
public class CRQ {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="CRQ_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int crqId;

    @Column(name = "Description")
    String description;

    @Column(name = "Creation_Date")
    Timestamp creationDate;

    public CRQ(){
        super();
    }

    public CRQ(int id, String desc) {
        Timestamp cDate = new Timestamp(System.currentTimeMillis());
        this.crqId = id;
        this.description = desc;
        this.creationDate = cDate;
    }

    public int getCrqId() {
        return crqId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCrqId(int crqId) {
        this.crqId = crqId;
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
        return "CRQ{" +
                "crqId=" + crqId +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
