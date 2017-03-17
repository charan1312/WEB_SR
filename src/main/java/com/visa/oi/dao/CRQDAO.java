package com.visa.oi.dao;

import com.visa.oi.model.CRQ;

/**
 * Created by caware on 2/28/2017.
 */
public interface CRQDAO {

    public CRQ listAllSigCrqs();

    public void updateSigCrqs(CRQ crq);
}

