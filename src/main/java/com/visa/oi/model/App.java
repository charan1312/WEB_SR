package com.visa.oi.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by caware on 12/21/2016.
 */
@Entity
@Table(name="APP")
public class App  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="App_ID")
    //@OneToMany(targetEntity = Item.class)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int appId;

    @Column(name = "Description", unique = true)
    String description;

    public App(){
        super();
    }

    public App(int id, String desc) {
        this.appId = id;
        this.description = desc;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "App{" +
                "appId=" + appId +
                ", description='" + description + '\'' +
                '}';
    }
}
