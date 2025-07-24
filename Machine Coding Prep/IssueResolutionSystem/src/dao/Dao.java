package dao;

import model.Agent;

import java.util.List;

public interface Dao<T> {

    String add(String id, Agent agent);

    T get(String id);

    List<T> getAll();
}
