package com.visa.oi.dao;

import com.visa.oi.model.App;
import com.visa.oi.model.Item;
import com.visa.oi.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by caware on 12/27/2016.
 */

@Repository
public class AppDAOImpl implements AppDAO {

    private static final Logger logger = LoggerFactory.getLogger(AppDAOImpl.class);
    private final String TABLE_NAME ="App";

    @PersistenceContext
    private EntityManager manager;

    /*@Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }
    */


    /*
    public List<App> listAllApps() {
        logger.debug("listAllApps(): is called" );
        //Session session = this.sessionFactory.getCurrentSession();
        //logger.debug("session object is: " + session.toString());
        //List<App> appList = session.createQuery("from App").list();
        CriteriaBuilder builder = HibernateUtil.getCriteriaBuilder();
        EntityManager em = HibernateUtil.getEntityManager();
        CriteriaQuery<App> criteriaQuery = builder.createQuery(App.class);
        Root<App> appRoot = criteriaQuery.from(App.class);
        criteriaQuery.select(appRoot);
        List<App> appList = em.createQuery(criteriaQuery).getResultList();
        logger.debug("No of Apps Count : " + appList.size());
        return appList;
    }
    */
    public List<App> listAllApps() {
        logger.debug("listAllApps(): is called" );
        //Session session = this.sessionFactory.getCurrentSession();
        //logger.debug("session object is: " + session.toString());
        //List<App> appList = session.createQuery("from App").list();
        List<App> appList = manager.createQuery("select a from App a",App.class).getResultList();
        logger.debug("No of Apps Count : " + appList.size());
        return appList;
    }


    /*
    public int getAppIdUsingDescription(String desc) {
        logger.debug("getAppIdUsingDescription(): is called" );
        //Session session = this.sessionFactory.getCurrentSession();
        //String sql = "from " + TABLE_NAME + " where " + "Description
        CriteriaBuilder builder = HibernateUtil.getCriteriaBuilder();
        EntityManager em = HibernateUtil.getEntityManager();
        CriteriaQuery<App> criteriaQuery = builder.createQuery(App.class);
        Root<App> appRoot = criteriaQuery.from(App.class);
        criteriaQuery.select(appRoot);
        criteriaQuery.where(builder.equal(appRoot.get("Description"),desc));
        App app = em.createQuery(criteriaQuery).getSingleResult();
        logger.info("Returned App Object:" + app );
        //List<App> apps = em.createQuery(criteriaQuery).getResultList();
        //for ( App app : apps) {
            return app.getAppId();
        //}
    }
    */
    public int getAppIdUsingDescription(String desc) {
        logger.debug("getAppIdUsingDescription(): is called" );
        //Session session = this.sessionFactory.getCurrentSession();
        //String sql = "from " + TABLE_NAME + " where " + "Description
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<App> criteriaQuery = builder.createQuery(App.class);
        Root<App> appRoot = criteriaQuery.from(App.class);
        criteriaQuery.select(appRoot);
        criteriaQuery.where(builder.equal(appRoot.get("description"),desc));
        App app = manager.createQuery(criteriaQuery).getSingleResult();
        logger.info("Returned App Object:" + app );
        return app.getAppId();
    }


    /*
    public String getAppDescUsingId(int id) {
        logger.debug("getAppDescUsingId(): is called" );
        //Session session = this.sessionFactory.getCurrentSession();
        //String sql = "from " + TABLE_NAME + " where " + "Description
        CriteriaBuilder builder = HibernateUtil.getCriteriaBuilder();
        EntityManager em = HibernateUtil.getEntityManager();
        CriteriaQuery<App> criteriaQuery = builder.createQuery(App.class);
        Root<App> appRoot = criteriaQuery.from(App.class);
        criteriaQuery.select(appRoot);
        criteriaQuery.where(builder.equal(appRoot.get("Id"),id));
        App app = em.createQuery(criteriaQuery).getSingleResult();
        logger.info("Returned App Object:" + app );
        //List<App> apps = em.createQuery(criteriaQuery).getResultList();
        //for ( App app : apps) {
        return app.getDescription();
        //}
    }
    */
    public String getAppDescUsingId(int id) {
        logger.debug("getAppDescUsingId(): is called" );
        //Session session = this.sessionFactory.getCurrentSession();
        //String sql = "from " + TABLE_NAME + " where " + "Description
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<App> criteriaQuery = builder.createQuery(App.class);
        Root<App> appRoot = criteriaQuery.from(App.class);
        criteriaQuery.select(appRoot);
        criteriaQuery.where(builder.equal(appRoot.get("Id"),id));
        App app = manager.createQuery(criteriaQuery).getSingleResult();
        logger.info("Returned App Object:" + app );
        return app.getDescription();
    }


    /*
    public void addApp(App app) {
        logger.debug("addApp(): is called" );
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(app);
        logger.info("App Added succesfully. " + app );
    }
    */
    public void addApp(App app) {
        logger.debug("addApp(): is called" );
        manager.persist(app);
        logger.info("App Added succesfully. " + app );
    }


}
