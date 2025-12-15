package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.services.FruitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruit")
public class FruitController {

    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping
    public List<Fruit> getFruits() {
        return fruitService.getByPriceAsc();
    }

    @GetMapping("/desc")
    public List<Fruit> getFruitsDesc() {
        return fruitService.getByPriceDesc();
    }

    @GetMapping("/name/{name}")
    public List<Fruit> getFruitsByName(@PathVariable String name) {
        return fruitService.searchByName(name);
    }

    @PostMapping
    public Fruit save(@RequestBody Fruit fruit) {
        return fruitService.save(fruit);
    }

    @GetMapping("/{id}")
    public Fruit getById(@PathVariable Long id) {
        return fruitService.getById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Fruit>> delete(@PathVariable Long id) {
        if (id < 0) {
            throw new PlantException("Id must be greater than or equal to 0", HttpStatus.BAD_REQUEST);
        }
        Fruit deleted = fruitService.delete(id);
        ApiResponse<Fruit> response = new ApiResponse<>(deleted, "Fruit deleted successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
