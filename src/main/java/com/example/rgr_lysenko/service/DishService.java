package com.example.rgr_lysenko.service;

import com.example.rgr_lysenko.model.Dish;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
@Service
public class DishService implements MenuService {
    private static final Map<Integer, Dish> DISH_REPOSITARY_MAP = new HashMap<>();
    private static final AtomicInteger DISH_ID_HOLDER = new AtomicInteger();
    @Override
    public void create(Dish dish){
        final int dishId = DISH_ID_HOLDER.incrementAndGet();
        dish.setId(dishId);
        DISH_REPOSITARY_MAP.put(dishId, dish);
    }
    @Override
    public List<Dish> readAll(){
        return new ArrayList<>(DISH_REPOSITARY_MAP.values());
    }
    @Override
    public Dish read(String name){
        for (Map.Entry<Integer, Dish> entry : DISH_REPOSITARY_MAP.entrySet()) {
            System.out.println(entry.getValue().getName());
            if (Objects.equals(entry.getValue().getName(), name)) return entry.getValue();
        }
        return null;
    }
    @Override
    public boolean update(Dish dish, int id){
        if(DISH_REPOSITARY_MAP.containsKey(id)){
            dish.setId(id);
            DISH_REPOSITARY_MAP.put(id, dish);
            return true;
        }
        return false;
    }
    @Override
    public boolean delete(int id){
        return DISH_REPOSITARY_MAP.remove(id) != null;
    }
}
