package service.impl;

import dao.AgentDaoImpl;
import model.*;
import model.enums.IssueType;
import model.enums.Status;
import service.AgentService;

import java.util.*;
import java.util.stream.Collectors;

public class AgentServiceImpl implements AgentService {

    AgentDaoImpl agentDao;

    IssueServiceImpl issueService;


    public AgentServiceImpl(AgentDaoImpl agentDao, IssueServiceImpl issueService) {
        this.agentDao = agentDao;
        this.issueService = issueService;
    }

    public void addAgent(String email, String name, List<String> issueType) {

        List<IssueType> issueTypes = issueType.stream().map(IssueType::fromString).collect(Collectors.toList());
        Agent agent = new Agent(email, name, issueTypes);
        agentDao.add(agent.getId(), agent);
        System.out.println("Agent " + agent.getId() + " created");

    }

    public void assignIssue(String issueId) {
        Agent agent = getAgentTobeAssigned();
        Issue issue = issueService.getIssue(issueId);
        if (agent.getWorkLog().getInProgressIssue().size() != 0) {
            agent.getWorkLog().getPendingIssue().add(issue);
            issue.setStatus(Status.OPEN);
            System.out.println("Issue " + issueId + " added to the waitlist of " + agent.getId());
        }
        else {
            agent.getWorkLog().getInProgressIssue().add(issue);
            issue.setStatus(Status.IN_PROGRESS);
            System.out.println("Issue " + issueId + " assigned to " + agent.getId());
        }
    }

    public List<Agent> getAllAvailableAgent() {

        List<Agent> agents = agentDao.getAll().stream()
                .filter(agent -> agent.getWorkLog().getInProgressIssue().isEmpty()).collect(Collectors.toList());

        return agents;
    }

    private Agent getAgentTobeAssigned() {

        int min = Integer.MAX_VALUE;
        Agent tobeAssigned = null;

        for (Agent agent : agentDao.getAll()) {
            int issues = agent.totalIssuesAssiged();
            if (issues < min) {
                tobeAssigned = agent;
                min = issues;
            }

        }

        return tobeAssigned;

    }

    public Map<String, List<String>> viewWorkHistory() {
        List<Agent> allAgents = agentDao.getAll();
        Map<String, List<String>> workHistory = new HashMap<>();

        allAgents.forEach(agent -> {
            List<String> issues = new ArrayList<>(agent.getWorkLog().getInProgressIssue().stream().
                    map(Issue::getId).collect(Collectors.toList()));
            issues.addAll(agent.getWorkLog().getPendingIssue().stream().
                    map(Issue::getId).collect(Collectors.toList()));
            agent.getWorkLog().getResolvedIssue().stream().
                    map(Issue::getId).collect(Collectors.toList());
            workHistory.put(agent.getId(), issues);
        });

        System.out.println(workHistory);

        return workHistory;


    }
}
