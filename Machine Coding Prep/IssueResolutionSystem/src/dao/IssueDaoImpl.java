package dao;

import model.Agent;
import model.Issue;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class IssueDaoImpl implements Dao<Issue> {

    private HashMap<String, Issue> issueMap = new HashMap<>();


    public HashMap<String, Issue> getIssueMap() {
        return issueMap;
    }

    public String add(String id, Issue issue) {
        issueMap.put(id, issue);
        return id;
    }

    @Override
    public String add(String id, Agent agent) {
        return null;
    }

    public Issue get(String id) {
        return issueMap.get(id);
    }

    @Override
    public List<Issue> getAll() {
        return null;
    }

    public List<Issue> getIssueByEmail(String email) {

        return issueMap.values().stream()
                .filter(issue -> issue.getEmail().equals(email))
                .collect(Collectors.toList());

    }

    public List<Issue> getIssueByType(String type) {

        return issueMap.values().stream()
                .filter(issue -> issue.getIssueType().toString().equals(type))
                .collect(Collectors.toList());
    }



}
