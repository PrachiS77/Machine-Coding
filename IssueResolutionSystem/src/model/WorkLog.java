package model;

import java.util.ArrayList;
import java.util.List;

public class WorkLog {

    List<Issue> resolvedIssue = new ArrayList<>();

    List<Issue> inProgressIssue = new ArrayList<>();

    List<Issue> pendingIssue = new ArrayList<>();

    public List<Issue> getResolvedIssue() {
        return resolvedIssue;
    }

    public void setResolvedIssue(List<Issue> resolvedIssue) {
        this.resolvedIssue = resolvedIssue;
    }

    public List<Issue> getInProgressIssue() {
        return inProgressIssue;
    }

    public void setInProgressIssue(List<Issue> inProgressIssue) {
        this.inProgressIssue = inProgressIssue;
    }

    public List<Issue> getPendingIssue() {
        return pendingIssue;
    }

    public void setPendingIssue(List<Issue> pendingIssue) {
        this.pendingIssue = pendingIssue;
    }
}
