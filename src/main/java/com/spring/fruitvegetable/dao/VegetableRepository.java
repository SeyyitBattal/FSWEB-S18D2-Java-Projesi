package com.spring.fruitvegetable.dao;

import com.spring.fruitvegetable.entity.Fruit;
import com.spring.fruitvegetable.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable, Long> {
    @Query(value = "SELECT v.id, v.name, v.price, v.grown_on_tree " +
            "FROM eat.vegetable as v ORDER BY v.price DESC", nativeQuery = true)
    List<Vegetable> orderForPriceHigh(double price);

    @Query(value = "SELECT v.id, v.name, v.price, v.grown_on_tree " +
            "FROM eat.vegetable as v ORDER BY v.price ASC", nativeQuery = true)
    List<Vegetable> orderForPriceLow(double price);

    @Query(value = "SELECT v.id, v.name, v.price, v.grown_on_tree " +
            "FROM eat.vegetable as v WHERE v.name = :name", nativeQuery = true)
    List<Vegetable> findByName(String name);
}
