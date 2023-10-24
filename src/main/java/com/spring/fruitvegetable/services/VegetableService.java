package com.spring.fruitvegetable.services;

import com.spring.fruitvegetable.entity.Vegetable;

import java.util.List;

public interface VegetableService {
    List<Vegetable> findAll();

    Vegetable find(long id);

    Vegetable save(Vegetable vegetable);

    Vegetable delete(long id);

    List<Vegetable> orderForPriceHigh(String name);

    List<Vegetable> findByGender(double price);

    List<Vegetable> orderForPriceLow(double price);

    List<Vegetable> findByName(String name);
}
