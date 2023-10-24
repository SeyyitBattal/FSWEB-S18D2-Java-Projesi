package com.spring.fruitvegetable.dao;

import com.spring.fruitvegetable.entity.Fruit;
import com.spring.fruitvegetable.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Long> {
    @Query(value = "SELECT v.id, v.name, v.price, v.fruit_type " +
            "FROM eat.fruit as v ORDER BY v.price DESC", nativeQuery = true)
    List<Fruit> orderForPriceHigh(double price);

    @Query(value = "SELECT v.id, v.name, v.price, v.fruit_type " +
            "FROM eat.fruit as v ORDER BY v.price ASC", nativeQuery = true)
    List<Fruit> orderForPriceLow(double price);

    @Query(value = "SELECT v.id, v.name, v.price, v.fruit_type " +
            "FROM eat.fruit as v WHERE v.name = :name", nativeQuery = true)
    List<Fruit> findByName(String name);


}
