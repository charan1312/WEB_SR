package com.visa.oi.dao;

import com.visa.oi.model.Item;

import java.util.List;

/**
 * Created by caware on 12/21/2016.
 */
public interface ItemDAO {

    public List<Item> listActionItems(int activeInd, int appId);

    public void addItem(Item item);

    public Item getItemWithId(int itemNo);

    public void updateItem(Item item);

    public Integer getCountForApp(int activeInd, int appId);

    public Integer getTotalCount(int activeInd);
}
