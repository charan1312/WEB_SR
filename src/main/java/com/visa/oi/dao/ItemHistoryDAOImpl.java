package com.visa.oi.dao;

import com.visa.oi.model.Item;
import com.visa.oi.model.ItemHistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by caware on 12/29/2016.
 */

@Repository
public class ItemHistoryDAOImpl implements ItemHistoryDAO {

    private static final Logger logger = LoggerFactory.getLogger(ItemHistoryDAOImpl.class);

    @PersistenceContext
    private EntityManager manager;


    public List<ItemHistory> listItemHistoryUsingID(int itemId) {
        logger.debug("listItemHistoryUsingID(): is called" );
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<ItemHistory> criteriaQuery = builder.createQuery(ItemHistory.class);
        Root<ItemHistory> itemHistoryRoot = criteriaQuery.from(ItemHistory.class);

        criteriaQuery.select(itemHistoryRoot);
        criteriaQuery.where(builder.equal(itemHistoryRoot.get("serialNo"),itemId));      //WHERE ID IS EQUALS SERIAL_NO
        criteriaQuery.orderBy(builder.asc(itemHistoryRoot.get("lastModified")));        // ORDER BY LAST_MODIFIED_TS

        List<ItemHistory> itemHistoryList = manager.createQuery(criteriaQuery).getResultList();
        logger.debug("itemHistoryList size is : " + itemHistoryList.size());
        return itemHistoryList;
    }

    public void addHistoryToItem(ItemHistory itemHistory) {
        logger.debug("addHistoryToItem(): is called" );
        manager.persist(itemHistory);
        logger.info("ITEM HISTORY that is added in DB:" + itemHistory );
    }
}
