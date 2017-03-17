package com.visa.oi.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by caware on 12/27/2016.
 */

public class HibernateUtil {

    public static final int actInd = 1;
    public static final int inActInd = 2;

    public static final String vbvAppName = "VBV";
    public static final String vcasAppName = "VCAS";
    public static final String tpcasAppName = "TPCAS";
    public static final String vdnaAppName = "VDNA";
    public static final String spsAppName = "SPS";

    public static final String ITEM_TABLE_NAME ="SR";
    public static final String ITEMHISTORY_TABLE_NAME ="AI_HISTORY";
    public static final String APP_TABLE_NAME ="APP";

    /*
    protected static final EntityManagerFactory emFactory;

    static {
        emFactory = Persistence.createEntityManagerFactory("com.visa.oi.model.App");
    }

    public static CriteriaBuilder getCriteriaBuilder(){
        CriteriaBuilder builder = emFactory.getCriteriaBuilder();
        return  builder;
    }

    public static EntityManager getEntityManager(){
        return emFactory.createEntityManager();
    }
    */
}
