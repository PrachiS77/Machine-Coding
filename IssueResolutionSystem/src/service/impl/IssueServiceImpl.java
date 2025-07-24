package service.impl;

import dao.IssueDaoImpl;
import model.Issue;
import model.enums.IssueType;
import service.IssueService;

import java.util.List;
import java.util.Map;

public class IssueServiceImpl implements IssueService {

    IssueDaoImpl issueDao;

    public IssueServiceImpl(IssueDaoImpl issueDao) {
        this.issueDao = issueDao;
    }

    public String createIssue(String transaction,
                              String issueType,
                              String subject,
                              String description,
                              String email) {

        Issue issue = new Issue(transaction, subject, description, IssueType.fromString(issueType), email);
        issueDao.add(issue.getId(), issue);
        System.out.println("Issue " + issue.getId()  + " created against " +  transaction + " transaction!");
        return issue.getId();
    }

    public Issue getIssue(String issueId) {
        return issueDao.get(issueId);
    }

    private void getIssueByEmail(String email) {
        List<Issue> issues = issueDao.getIssueByEmail(email);
        printIssues(issues);
    }

    private static void printIssues(List<Issue> issues) {
        issues.forEach(issue -> {
            System.out.println(issue.getId() + " { " +
                    issue.getTransactionId() + ", " +
                    issue.getEmail() + ", " +
                    issue.getSubject() + ", " +
                    issue.getDescription() + ", " +
                    issue.getIssueType().toString() + ", " +
                    issue.getStatus() + " }");
        });
    }

    private void getIssueByType(String type) {
        List<Issue> issues = issueDao.getIssueByEmail(type);
        printIssues(issues);
    }

    public void getIssue(Map<String, String> searchBy) {

        String val = searchBy.keySet().stream().findFirst().get();

        switch (val) {
            case "email" :
                getIssueByEmail(searchBy.get(val));
                break;
            case "type" :
                getIssueByType(searchBy.get(val));
                break;
         }



    }


}
