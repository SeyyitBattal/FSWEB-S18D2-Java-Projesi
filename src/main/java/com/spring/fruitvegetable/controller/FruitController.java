package com.spring.fruitvegetable.controller;

import com.spring.fruitvegetable.entity.Fruit;
import com.spring.fruitvegetable.services.FruitService;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/fruits")
public class FruitController {

    private FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping("/")
    public Fruit save(@Validated @RequestBody Fruit fruit) {
        return fruitService.save(fruit);
    }

    @GetMapping("/")
    public List<Fruit> findAll() {
        return fruitService.findAll();
    }

    @GetMapping("/{id}")
    public Fruit find(@PathVariable long id) {
        return fruitService.find(id);
    }

    @GetMapping("/byName/{name}")
    public List<Fruit> findByName(@PathVariable String name) {
        return fruitService.findByName(name);
    }

    @GetMapping("/desc/{price}")
    public List<Fruit> priceHightoLow(@PathVariable double price) {
        return fruitService.orderForPriceHigh(price);
    }

    @DeleteMapping("/{id}")
    public Fruit remove(@Positive @PathVariable long id) {
        return fruitService.delete(id);
    }

}
