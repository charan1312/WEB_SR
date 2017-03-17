package com.visa.oi.service;

import com.visa.oi.model.Issue;

/**
 * Created by caware on 2/28/2017.
 */
public interface IssueService {

    public Issue listAllSigIssues();

    public void updateSigIssues(Issue issue);

}
