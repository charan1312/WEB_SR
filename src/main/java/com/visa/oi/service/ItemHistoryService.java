package com.visa.oi.service;

import com.visa.oi.model.Item;
import com.visa.oi.model.ItemHistory;

import java.util.List;

/**
 * Created by caware on 12/29/2016.
 */
public interface ItemHistoryService {

    public List<ItemHistory> listItemHistoryUsingID(int id);

    public void addHistoryToItem(ItemHistory itemHistory);

    // Methods local to Service and not present in DAO
    public ItemHistory copyReqFieldsFromItem(Item item);
}
