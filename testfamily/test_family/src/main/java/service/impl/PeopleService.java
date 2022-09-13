package service.impl;

import models.People;
import repository.IPeopleRepository;
import repository.impl.PeopleRepository;
import service.IPeopleService;

import java.util.List;

public class PeopleService implements IPeopleService<People> {
IPeopleRepository<People> repository = new PeopleRepository();

    @Override
    public List<People> findAllByIdHouse(String id) {
        return repository.findAllByIdHouse(id);
    }
}
