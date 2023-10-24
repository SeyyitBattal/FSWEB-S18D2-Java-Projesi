package com.spring.fruitvegetable.services;

import com.spring.fruitvegetable.dao.FruitRepository;
import com.spring.fruitvegetable.entity.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService {

    private FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public List<Fruit> findAll() {
        return fruitRepository.findAll();
    }

    @Override
    public Fruit find(long id) {
        Optional<Fruit> fruitOptional = fruitRepository.findById(id);
        return fruitOptional.get();
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit delete(long id) {
        Fruit fruit = find(id);
        fruitRepository.delete(fruit);
        return fruit;
    }

    @Override
    public List<Fruit> orderForPriceHigh(double price) {
        return fruitRepository.orderForPriceHigh(price);
    }

    @Override
    public List<Fruit> orderForPriceLow(double price) {
        return fruitRepository.orderForPriceLow(price);
    }

    @Override
    public List<Fruit> findByName(String name) {
        return fruitRepository.findByName(name);
    }
}
