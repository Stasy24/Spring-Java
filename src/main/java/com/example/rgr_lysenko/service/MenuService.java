package com.example.rgr_lysenko.service;

import com.example.rgr_lysenko.model.Dish;

import java.util.List;



public interface MenuService {
    /*

     * Створює нову страву

     * @param dish - страва для створення

     */     void create(Dish dish);

    /**
     * Повертає список усіх доступних страв.
     *
     * @return список їжі
     */      List<Dish> readAll();

    /**

     * Повертає клієнта за його ідентифікаційним номером

     * @param name - ID їжі

     * @return – об’єкт їжі с заданим ID

     */  Dish read(String name);

    /**

     * Оновлює їжу зазначеним ID,

     * за переказом клієнта

     * @param dish - їжа, відповідно до якої потрібно оновити дані

     * @param id - ID їжі, який потребує оновлення

     * @return - true, якщо дані були оновлені, в іншому випадку false

     */  boolean update(Dish dish, int id);



    /**

     * Видаляється їжа із зазначеним ID

     * @param id - ідентифікатор їжі, якого потрібно видалити

     * @return - true, якщо клієнт був видалений, в іншому випадку false

     */ boolean delete(int id);
}