package com.visa.oi.service;

import com.visa.oi.dao.ItemDAO;
import com.visa.oi.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by caware on 12/21/2016.
 */

public interface ItemService {

    public List<Item> listActionItems(int activeInd, int appId);

    public void addItem(Item item);

    public Item getItemWithId(int itemNo);

    public void updateItem(Item item);

    public Integer getCountForApp(int activeInd, int appId);

    public Integer getTotalCount(int activeInd);

    // Methods local to Service and not present in DAO
    public Item copyItem(Item item);

    public Item copyReqFieldsFromOneItemToAnother(Item from,Item to);

}
