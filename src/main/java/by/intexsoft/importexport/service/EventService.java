package by.intexsoft.importexport.service;

import by.intexsoft.importexport.pojo.TypeEvent;

import java.util.List;

public interface EventService<T> {
    List<T> getAll();
    void save(Object object, TypeEvent typeEvent);

}
