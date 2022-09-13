package repository;

import models.People;

import java.util.List;

public interface IPeopleRepository<E> {
    List<People> findAllByIdHouse(String id);

    String getAllName(String id_search);
}
