package com.visa.oi.service;

import com.visa.oi.model.CRQ;

/**
 * Created by caware on 2/28/2017.
 */
public interface CRQService {

    public CRQ listAllSigCrqs();

    public void updateSigCrqs(CRQ crq);

}
