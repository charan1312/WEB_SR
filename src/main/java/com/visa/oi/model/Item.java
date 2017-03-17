package com.visa.oi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Created by caware on 12/20/2016.
 */
@Entity
@Table(name="SR")
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="Serial_No")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int serialNo;

    @Column(name="Active_Ind")
    int activeInd;


    @Column(name = "App_ID")
    @JoinColumn(name = "App_ID")
    int appId;

    @Column(name = "Creation_Date")
    Timestamp creationDate;

    @Column(name = "Summary")
    String summary;

    @Column(name = "Description")
    String description;

    @Column(name = "Last_Modified")
    Timestamp lastModified;

    public Item(){
        super();
    }

    public Item(int sNo,int aI,int apId, String sum,String desc) {
        Timestamp cDate = new Timestamp(System.currentTimeMillis());
        this.serialNo = sNo;
        this.activeInd = aI;
        this.appId = apId;
        this.creationDate = cDate;
        this.summary = sum;
        this.description = desc;
        this.lastModified = cDate;
    }

    public int getSerialNo() {

        return serialNo;
    }

    public void setSerialNo(int serialNo) {

        this.serialNo = serialNo;
    }

    public int getActiveInd() {

        return activeInd;
    }

    public void setActiveInd(int activeInd)
    {
        this.activeInd = activeInd;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {

        this.appId = appId;
    }

    public Timestamp getCreationDate() {

        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {

        this.creationDate = creationDate;
    }

    public String getSummary() {

        return summary;
    }

    public void setSummary(String summary) {

        this.summary = summary;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public Timestamp getLastModified() {

        return lastModified;
    }

    public void setLastModified(Timestamp lastModified) {

        this.lastModified = lastModified;
    }

    @Override
    public String toString() {
        return "Item{" +
                "serialNo=" + serialNo +
                ", activeInd=" + activeInd +
                ", appId=" + appId +
                ", creationDate=" + creationDate +
                ", summary='" + summary + '\'' +
                ", description='" + description + '\'' +
                ", lastModified=" + lastModified +
                '}';
    }
}
