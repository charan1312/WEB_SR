package com.visa.oi.service;

import com.visa.oi.dao.AppDAO;
import com.visa.oi.dao.IssueDAO;
import com.visa.oi.model.Issue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

/**
 * Created by caware on 2/28/2017.
 */

@Service
public class IssueServiceImpl implements IssueService{

    private static final Logger logger = LoggerFactory.getLogger(IssueServiceImpl.class);

    @Autowired
    private IssueDAO issueDAO;

    @Transactional
    public Issue listAllSigIssues() {
        logger.debug("listAllSigIssues(): is called");
        return this.issueDAO.listAllSigIssues();
    }

    @Transactional
    public void updateSigIssues(Issue issue) {
        logger.debug("updateSigIssues(): is called");

        Timestamp cDate = new Timestamp(System.currentTimeMillis());

        if( issue.getCreationDate()==null ) {
            issue.setCreationDate(cDate);
        }

        this.issueDAO.updateSigIssues(issue);
    }
}
