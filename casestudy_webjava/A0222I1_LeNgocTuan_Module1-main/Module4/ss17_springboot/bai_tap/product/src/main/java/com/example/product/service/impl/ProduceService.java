package com.example.product.service.impl;

import com.example.product.models.Produce;
import com.example.product.repository.IProduceRepository;
import com.example.product.service.IProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProduceService implements IProduceService {
    @Autowired
    IProduceRepository repository;

    @Override
    public Iterable<Produce> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Produce> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void save(Produce produce) {
        repository.save(produce);
    }

//    public void update(Produce produce){
//        repository.saveAndFlush(produce).
//    }
    @Override
    public void remove(Integer id) {
        repository.deleteById(id);
    }
}
