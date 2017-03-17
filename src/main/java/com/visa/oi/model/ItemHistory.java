package com.visa.oi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Created by caware on 12/21/2016.
 */

@Entity
@Table(name="AI_HISTORY")
public class ItemHistory  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "Serial_No")
    @JoinColumn(name = "Serial_No")
    int serialNo;

    @Column(name = "Summary")
    String summary;

    @Column(name = "Description")
    String description;

    @Id
    @Column(name = "Last_Modified")
    Timestamp lastModified;

    public ItemHistory(){
        super();
    }

    public ItemHistory(int sNo,String sum,String desc) {
        Timestamp lmDate =  new Timestamp(System.currentTimeMillis());
        this.serialNo = sNo;
        this.summary = sum;
        this.description = desc;
        this.lastModified = lmDate;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
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
        return "ItemHistory{" +
                "serialNo=" + serialNo +
                ", summary='" + summary + '\'' +
                ", description='" + description + '\'' +
                ", lastModified=" + lastModified +
                '}';
    }
}
