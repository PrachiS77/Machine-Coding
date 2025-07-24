package model;

import model.enums.IssueType;
import model.enums.Status;

public class Issue {

    private static int idCounter = 0;

    String id;

    String transactionId;

    String subject;

    String description;

    IssueType issueType;

    String email;

    Status status;


    public Issue(String transactionId, String subject, String description, IssueType issueType, String email) {
        this.transactionId = transactionId;
        this.subject = subject;
        this.description = description;
        this.issueType = issueType;
        this.email = email;
        this.id = "I" + ++idCounter;
        this.status = Status.OPEN;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public IssueType getIssueType() {
        return issueType;
    }

    public void setIssueType(IssueType issueType) {
        this.issueType = issueType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }
}
