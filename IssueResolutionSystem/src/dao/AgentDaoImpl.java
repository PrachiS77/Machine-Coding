package dao;

import model.Agent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AgentDaoImpl implements Dao<Agent> {

    private HashMap<String, Agent> agentMap = new HashMap<>();


    public String add(String id, Agent agent) {
        agentMap.put(id, agent);
        return id;
    }

    public Agent get(String id) {
        return agentMap.get(id);
    }

    public List<Agent> getAll() {
        return new ArrayList<>(agentMap.values());
    }
}
