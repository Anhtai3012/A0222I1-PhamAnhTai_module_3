package service;

import models.People;

import java.util.List;

public interface IPeopleService<E> {
      List<E> findAllByIdHouse(String id);

}
