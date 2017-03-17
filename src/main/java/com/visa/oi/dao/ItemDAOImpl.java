package com.visa.oi.dao;

import com.visa.oi.model.App;
import com.visa.oi.model.Item;
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
 * Created by caware on 12/21/2016.
 */

@Repository
public class ItemDAOImpl implements ItemDAO{

    private static final Logger logger = LoggerFactory.getLogger(ItemDAOImpl.class);

    @PersistenceContext
    private EntityManager manager;

    /*
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }
    */

    /*
    public List<Item> listActionItems(int activeInd, int appId) {
        logger.debug("listActionItems(): is called" );
        Session session = this.sessionFactory.getCurrentSession();
        logger.debug("session object is: " + session.toString());
        List<Item> itemList = session.createQuery("from Item").list();      //where App_Id=1 and Active_Ind=1
        //List<Item> ItemList
        logger.debug("itemList size is : " + itemList.size());
        return itemList;
    }
    */
    public List<Item> listActionItems(int activeInd, int appId) {
        logger.debug("listActionItems(): is called" );
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Item> criteriaQuery = builder.createQuery(Item.class);
        Root<Item> itemRoot = criteriaQuery.from(Item.class);

        criteriaQuery.select(itemRoot);

        criteriaQuery.where(builder.equal(itemRoot.get("activeInd"),activeInd),          //where App_Id=1 and Active_Ind=1
                            builder.equal(itemRoot.get("appId"),appId));
        //criteriaQuery.where(builder.equal(itemRoot.get("activeInd"),activeInd));
        // criteriaQuery.where(builder.equal(itemRoot.get("appId"),appId));

        List<Item> itemList = manager.createQuery(criteriaQuery).getResultList();
        logger.debug("ITEMLIST size fetched from running the DB Query: " + itemList.size());
        return itemList;
    }


    public Item getItemWithId(int itemNo){
        logger.debug("getItemwithId(): is called");
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Item> criteriaQuery = builder.createQuery(Item.class);
        Root<Item> itemRoot = criteriaQuery.from(Item.class);
        criteriaQuery.select(itemRoot);
        criteriaQuery.where(builder.equal(itemRoot.get("serialNo"),itemNo));
        Item item = manager.createQuery(criteriaQuery).getSingleResult();
        logger.info("ITEM Object fetched from running the DB Query:" + item );
        return item;
    }

    /*
    public void addItem(Item item) {
        logger.debug("addItem(): is called" );
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(item);
        logger.info("Item Added succesfully. " + item );
    }
    */
    public void addItem(Item item) {
        logger.debug("addItem(): is called" );
        manager.persist(item);
        logger.info("ITEM Object which is added successfully to the DB:" + item );
    }


    public void updateItem(Item item) {
        logger.debug("updateItem(): is called" );
    /*    manager.getTransaction().begin();
        Item newUpdate = manager.find(Item.class,item.getSerialNo());
        newUpdate.setCreationDate(item.getCreationDate());
        newUpdate.setDescription(item.getDescription());
        newUpdate.setLastModified(item.getLastModified());
        newUpdate.setSummary(item.getSummary());
        newUpdate.setAppId(item.getAppId());
        newUpdate.setActiveInd(item.getActiveInd());
        manager.getTransaction().commit();
    */
        manager.merge(item);
        logger.info("ITEM Object which is updated successfully to the DB:" + item );
    }


    public Integer getCountForApp(int activeInd, int appId) {
        logger.debug("getCountForApp(): is called" );
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Item> criteriaQuery = builder.createQuery(Item.class);
        Root<Item> itemRoot = criteriaQuery.from(Item.class);

        criteriaQuery.select(itemRoot);

        criteriaQuery.where(builder.equal(itemRoot.get("activeInd"),activeInd),
                builder.equal(itemRoot.get("appId"),appId));

        List<Item> itemList = manager.createQuery(criteriaQuery).getResultList();
        return itemList.size();
    }

    public Integer getTotalCount(int activeInd){
        logger.debug("getTotalCount(): is called" );
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Item> criteriaQuery = builder.createQuery(Item.class);
        Root<Item> itemRoot = criteriaQuery.from(Item.class);

        criteriaQuery.select(itemRoot);

        criteriaQuery.where(builder.equal(itemRoot.get("activeInd"),activeInd));

        List<Item> itemList = manager.createQuery(criteriaQuery).getResultList();
        return itemList.size();
    }

}
