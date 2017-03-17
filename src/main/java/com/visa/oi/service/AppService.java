package com.visa.oi.service;

import com.visa.oi.model.App;
import com.visa.oi.model.Item;

import java.util.List;

/**
 * Created by caware on 12/24/2016.
 */
public interface AppService {

    public List<App> listAllApps();

    public int getAppIdUsingDescription(String desc);

    public String getAppDescUsingId(int id);

    public void addApp(App app);

}