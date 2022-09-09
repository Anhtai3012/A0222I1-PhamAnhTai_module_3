package com.produce.service;

import com.produce.models.Produce;

import java.util.List;
import java.util.Map;

public interface IProduceService {
    Produce findById(int id);

    void removeById(int id);

    void save(Produce produce);

    void update(Produce produce);

    Map<Integer,Produce> findAll();
}
