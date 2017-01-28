package com.visa.oi.dao;

import com.visa.oi.model.ItemHistory;

import java.util.List;

/**
 * Created by caware on 12/29/2016.
 */
public interface ItemHistoryDAO {

    public List<ItemHistory> listItemHistoryUsingID(int id);

    public void addHistoryToItem(ItemHistory itemHistory);
}
