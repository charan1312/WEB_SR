package com.visa.oi.dao;

import com.visa.oi.model.Issue;

/**
 * Created by caware on 2/28/2017.
 */
public interface IssueDAO {

    public Issue listAllSigIssues();

    public void updateSigIssues(Issue issue);
}
