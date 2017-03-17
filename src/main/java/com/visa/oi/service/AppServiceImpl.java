package com.visa.oi.service;

import com.visa.oi.dao.AppDAO;
import com.visa.oi.dao.ItemDAO;
import com.visa.oi.model.App;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by caware on 12/24/2016.
 */

@Service
public class AppServiceImpl implements AppService {

    private static final Logger logger = LoggerFactory.getLogger(AppServiceImpl.class);

    @Autowired
    private AppDAO appDAO;

    @Transactional
    public List<App> listAllApps() {
        logger.debug("listAllApps(): is called");
        return this.appDAO.listAllApps();
    }

    public int getAppIdUsingDescription(String desc) {
        logger.debug("getAppIdUsingDescription(): is called");
        return this.appDAO.getAppIdUsingDescription(desc);
    }

    public String getAppDescUsingId(int id) {
        logger.debug("getAppDescUsingId(): is called");
        return this.appDAO.getAppDescUsingId(id);
    }

    public void addApp(App app) {
        logger.debug("addApp(): is called");
        this.appDAO.addApp(app);
    }
}
