package com.visa.oi.service;

import com.visa.oi.dao.CRQDAO;
import com.visa.oi.dao.IssueDAO;
import com.visa.oi.model.CRQ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * Created by caware on 2/28/2017.
 */

@Service
public class CRQServiceImpl implements CRQService {

    private static final Logger logger = LoggerFactory.getLogger(CRQServiceImpl.class);

    @Autowired
    private CRQDAO crqDAO;

    public CRQ listAllSigCrqs() {
        logger.debug("listAllSigCrqs(): is called");
        return this.crqDAO.listAllSigCrqs();
    }

    public void updateSigCrqs(CRQ crq) {
        logger.debug("updateSigCrqs(): is called");

        Timestamp cDate = new Timestamp(System.currentTimeMillis());

        if( crq.getCreationDate()==null ) {
            crq.setCreationDate(cDate);
        }

        this.crqDAO.updateSigCrqs(crq);
    }
}
