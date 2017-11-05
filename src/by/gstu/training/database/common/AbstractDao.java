package by.gstu.training.database.common;

import by.gstu.training.model.Entity;

import java.util.List;

public interface AbstractDao <K,T extends Entity> {
    List<T> findAll();
    T find(K id);
}
