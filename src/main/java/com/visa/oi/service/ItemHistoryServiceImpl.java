package com.visa.oi.service;

import com.visa.oi.dao.ItemHistoryDAO;
import com.visa.oi.model.Item;
import com.visa.oi.model.ItemHistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by caware on 12/29/2016.
 */

@Service
public class ItemHistoryServiceImpl implements ItemHistoryService{

    private static final Logger logger = LoggerFactory.getLogger(ItemHistoryServiceImpl.class);

    @Autowired
    private ItemHistoryDAO itemHistoryDAO;

    @Transactional
    public List<ItemHistory> listItemHistoryUsingID(int id) {
        logger.debug("listItemHistoryUsingID(): is called");
        return this.itemHistoryDAO.listItemHistoryUsingID(id);
    }

    @Transactional
    public void addHistoryToItem(ItemHistory itemHistory) {
        logger.debug("addHistoryToItem(): is called");

        Timestamp cDate = new Timestamp(System.currentTimeMillis());
        // All the Business Constraints regarding the Item object are checked before adding it to the DB
        //Item Objects Creation Date and Last updated Date cannot be null
        if( itemHistory.getLastModified()==null ) {
            itemHistory.setLastModified(cDate);
        }

        //Finally sending the Object to be persisted in the DB
        logger.debug("ITEM HISTORY that is being sent to DB:" + itemHistory);
        this.itemHistoryDAO.addHistoryToItem(itemHistory);
    }

    @Transactional
    public ItemHistory copyReqFieldsFromItem(Item item){

        logger.debug("copyReqFieldsFromItem(): is called");
        ItemHistory latestHistory = new ItemHistory();

        //Timestamp cDate = new Timestamp(System.currentTimeMillis());    -- Kept as a generic here

        latestHistory.setLastModified(item.getLastModified());
        latestHistory.setSummary(item.getSummary());
        latestHistory.setDescription(item.getDescription());
        latestHistory.setSerialNo(item.getSerialNo());

        logger.debug("Copied ITEM HISTORY object:" + latestHistory);
        return latestHistory;
    }

}
