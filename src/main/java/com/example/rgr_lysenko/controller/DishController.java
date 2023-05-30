package com.example.rgr_lysenko.controller;
import com.example.rgr_lysenko.model.Dish;
import com.example.rgr_lysenko.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class DishController {    private final MenuService menuService;
    @Autowired
    public DishController(MenuService menuService){
        this.menuService = menuService;
    }
    @PostMapping(value = "/dishes")
    public ResponseEntity<?> create(@RequestBody Dish dish){
        menuService.create(dish);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/dishes")
    public ResponseEntity<List<Dish>> read(){
        final List<Dish> dishes = menuService.readAll();

        return dishes != null && !dishes.isEmpty()
                ? new ResponseEntity<>(dishes, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/dishes/{name}")
    public ResponseEntity<Dish> read(@PathVariable(name = "name") String name){
        final Dish dish = menuService.read(name);

        return dish != null
                ? new ResponseEntity<>(dish, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/dishes/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Dish dish){
        final boolean updated = menuService.update(dish, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping(value = "/dishes/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id, @RequestBody Dish dish){
        final boolean deleted = menuService.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
