package service;

import model.Agent;
import java.util.List;
import java.util.Map;

public interface AgentService {

    void addAgent(String email, String name, List<String> issueType);

    void assignIssue(String issueId);

    List<Agent> getAllAvailableAgent();

    Map<String, List<String>> viewWorkHistory();
}
