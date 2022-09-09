package com.produce.repository;

import com.produce.models.Produce;

import java.util.Map;

public interface IProduceRepos {
   Produce findById(int id);

   void removeById(int id);

   void save(Produce produce);

   void update(Produce produce);

   Map<Integer, Produce> findAll();
}
