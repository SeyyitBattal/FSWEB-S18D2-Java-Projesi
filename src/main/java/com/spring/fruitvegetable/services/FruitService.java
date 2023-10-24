package com.spring.fruitvegetable.services;

import com.spring.fruitvegetable.entity.Fruit;

import java.util.List;

public interface FruitService {
    List<Fruit> findAll();

    Fruit find(long id);

    Fruit save(Fruit fruit);

    Fruit delete(long id);

    List<Fruit> orderForPriceHigh(double price);


    List<Fruit> orderForPriceLow(double price);

    List<Fruit> findByName(String name);

}
