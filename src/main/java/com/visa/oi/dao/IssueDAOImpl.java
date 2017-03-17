package com.visa.oi.dao;

import com.visa.oi.model.App;
import com.visa.oi.model.Issue;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by caware on 2/28/2017.
 */

@Repository
public class IssueDAOImpl implements IssueDAO{

    private static final Logger logger = LoggerFactory.getLogger(IssueDAOImpl.class);
    private final String TABLE_NAME ="ISSUE";


    @PersistenceContext
    private EntityManager manager;

    public Issue listAllSigIssues() {
        logger.debug("listAllSigIssues(): is called" );
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Issue> criteriaQuery = builder.createQuery(Issue.class);
        Root<Issue> issueRoot = criteriaQuery.from(Issue.class);
        criteriaQuery.select(issueRoot);
        criteriaQuery.orderBy(builder.desc(issueRoot.get("issueId")));
        Issue issue = manager.createQuery(criteriaQuery).setMaxResults(1).getSingleResult();           //getSingleResult();
        logger.info("Returned Issue Object:" + issue );
        return issue;
    }

    public void updateSigIssues(Issue issue) {
        logger.debug("updateSigIssues(): is called" );
        manager.persist(issue);
        logger.info("Issue Object which is added successfully to the DB:" + issue );
    }
}
