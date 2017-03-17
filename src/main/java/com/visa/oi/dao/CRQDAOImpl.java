package com.visa.oi.dao;

import com.visa.oi.model.CRQ;
import com.visa.oi.model.Issue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by caware on 2/28/2017.
 */

@Repository
public class CRQDAOImpl implements CRQDAO{

    private static final Logger logger = LoggerFactory.getLogger(CRQDAOImpl.class);
    private final String TABLE_NAME ="CRQ";

    @PersistenceContext
    private EntityManager manager;

    public CRQ listAllSigCrqs() {
        logger.debug("listAllSigCrqs(): is called" );
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<CRQ> criteriaQuery = builder.createQuery(CRQ.class);
        Root<CRQ> crqRoot = criteriaQuery.from(CRQ.class);
        criteriaQuery.select(crqRoot);
        criteriaQuery.orderBy(builder.desc(crqRoot.get("crqId")));
        CRQ crq = manager.createQuery(criteriaQuery).getSingleResult();
        logger.info("Returned App Object:" + crq );
        return crq;
    }

    public void updateSigCrqs(CRQ crq) {
        logger.debug("updateSigCrqs(): is called" );
        manager.persist(crq);
    logger.info("CRQ Object which is added successfully to the DB:" + crq );
    }
}
