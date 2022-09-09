package com.produce.service;

import com.produce.models.Produce;
import com.produce.repository.IProduceRepos;
import com.produce.repository.ProduceRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProduceService implements IProduceService {
    @Autowired
    IProduceRepos produceRepos = new ProduceRepos();

    @Override
    public Produce findById(int id) {
        return produceRepos.findById(id);
    }

    @Override
    public void removeById(int id) {
        produceRepos.removeById(id);
    }

    @Override
    public void save(Produce produce) {
        produceRepos.save(produce);
    }

    @Override
    public void update(Produce produce) {
        produceRepos.update(produce);
    }

    @Override
    public Map<Integer, Produce> findAll() {
        return produceRepos.findAll();
    }
}
