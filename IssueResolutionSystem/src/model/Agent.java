package model;

import model.enums.IssueType;

import java.util.ArrayList;
import java.util.List;

public class Agent {

    private static int counter = 0;

    String id;

    String name;

    String email;

    List<IssueType> supportIssue = new ArrayList<>();

    WorkLog workLog = new WorkLog();


    public Agent(String email, String name, List<IssueType> supportIssue) {
        this.name = name;
        this.email = email;
        this.supportIssue = supportIssue;
        this.id = "A" + ++counter;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<IssueType> getSupportIssue() {
        return supportIssue;
    }

    public void setSupportIssue(List<IssueType> supportIssue) {
        this.supportIssue = supportIssue;
    }

    public WorkLog getWorkLog() {
        return workLog;
    }

    public void setWorkLog(WorkLog workLog) {
        this.workLog = workLog;
    }

    public int totalIssuesAssiged() {
        return this.workLog.getInProgressIssue().size()
                + this.workLog.getPendingIssue().size();
    }
}
