package service;

import model.Issue;
import model.enums.IssueType;

import java.util.List;
import java.util.Map;

public interface IssueService {

    String createIssue(String transaction,
                              String issueType,
                              String subject,
                              String description,
                              String email);
    Issue getIssue(String issueId);


    void getIssue(Map<String, String> searchBy);
}
