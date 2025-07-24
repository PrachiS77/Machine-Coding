import dao.AgentDaoImpl;
import dao.IssueDaoImpl;
import service.impl.AgentServiceImpl;
import service.impl.IssueServiceImpl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Customer Resolution Portal!!");

        IssueDaoImpl issueDao = new IssueDaoImpl();

        IssueServiceImpl issueService = new IssueServiceImpl(issueDao);

        AgentDaoImpl agentDao = new AgentDaoImpl();

        AgentServiceImpl agentService = new AgentServiceImpl(agentDao, issueService);

        issueService.createIssue("T1", "Payment Related", "Payment Failed", "My payment failed but money is debited", "testUser1@test.com");

        issueService.createIssue("T2", "Mutual Fund Related", "Purchase Failed", "Unable to purchase Mutual Fund", "testUser2@test.com");

        issueService.createIssue("T3", "Payment Related", "Payment Failed", "My payment failed but money is debited", "testUser2@test.com");

        agentService.addAgent("agent1@test.com", "Agent 1", Arrays.asList("Payment Related", "Gold Related"));

        agentService.addAgent("agent2@test.com", "Agent 2", Arrays.asList("Payment Related"));

        agentService.assignIssue("I1");

        agentService.assignIssue("I2");

        agentService.assignIssue("I3");

        Map<String, String> searchBy = new HashMap<>();

        searchBy.put("email", "testUser2@test.com");

        issueService.getIssue(searchBy);

        agentService.viewWorkHistory();



    }




    /**
     *
     * createIssue("T1", "Payment Related", "Payment Failed", "My payment failed but money is debited", "testUser1@test.com");
     * >>> Issue I1 created against transaction "T1"
     *
     * createIssue("T2", "Mutual Fund Related", "Purchase Failed", "Unable to purchase Mutual Fund", "testUser2@test.com");
     * >>> Issue I2 created against transaction "T2"
     *
     * createIssue("T3", "Payment Related", "Payment Failed", "My payment failed but money is debited", "testUser2@test.com");
     * >>> Issue I3 created against transaction "T3"
     *
     *
     * addAgent("agent1@test.com", "Agent 1", Arrays.asList("Payment Related", "Gold Related"));
     * >>> Agent A1 created
     *
     * addAgent("agent2@test.com", "Agent 2", Arrays.asList("Payment Related"));
     * >>> Agent A2 created
     *
     *
     * assignIssue("I1")
     * >>> Issue I1 assigned to agent A1
     *
     * assignIssue("I2")
     * >>> Issue I2 assigned to agent A2
     *
     * assignIssue("I3")
     * >>> Issue I3 added to waitlist of Agent A1
     *
     *
     * getIssue({"email": "testUser2@test.com"});
     * >>> I2 {"T2", "Mutual Fund Related", "Purchase Failed", "Unable to purchase Mutual Fund", "testUser2@test.com", "Open"},
     *  I3 {"T3", "Payment Related", "Payment Failed", "My payment failed but money is debited", , "testUser2@test.com", "Open"}
     *
     * getIssue({"type": "Payment Related"});
     * >>> I1{"T1", "Payment Related", "Payment Failed", "My payment failed but money is debited", "testUser1@test.com", "Open"},
     *  I3 {"T3", "Payment Related", "Payment Failed", "My payment failed but money is debited", "testUser1@test.com", "Open"}
     *
     *
     * updateIssue("I3", "In Progress", "Waiting for payment confirmation");
     * >>> I3 status updated to In Progress
     *
     *
     * resolveIssue("I3", "PaymentFailed debited amount will get reversed");
     * >>> I3 issue marked resolved
     *
     *
     * viewAgentsWorkHistory()
     * >>> A1 -> {I1, I3},
     *     A2 -> {I2}
     */
}