package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.VegetableRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VegetableServiceImpl implements VegetableService {

    private final VegetableRepository vegetableRepository;

    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public List<Vegetable> getByPriceAsc() {
        return vegetableRepository.getByPriceAsc();
    }

    @Override
    public List<Vegetable> getByPriceDesc() {
        return vegetableRepository.getByPriceDesc();
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableRepository.searchByName(name);
    }

    @Override
    public Vegetable getById(Long id) {
        if (id < 0) {
            throw new PlantException("Id must be greater than or equal to 0", HttpStatus.BAD_REQUEST);
        }
        return vegetableRepository.findById(id)
                .orElseThrow(() -> new PlantException("Vegetable not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public Vegetable delete(Long id) {
        Vegetable found = getById(id);
        vegetableRepository.delete(found);
        return found;
    }
}

