package com.visa.oi.dao;

import com.visa.oi.model.App;

import java.util.List;

/**
 * Created by caware on 12/24/2016.
 */
public interface AppDAO {

    public List<App> listAllApps();

    public int getAppIdUsingDescription(String desc);

    public String getAppDescUsingId(int id);

    public void addApp(App app);

}
