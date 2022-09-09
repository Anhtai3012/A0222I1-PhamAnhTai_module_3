package com.example.product.repository;

import com.example.product.models.Produce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProduceRepository extends JpaRepository<Produce, Integer> {

}
