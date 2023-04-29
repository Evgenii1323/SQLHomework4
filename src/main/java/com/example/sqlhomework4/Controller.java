package com.example.sqlhomework4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    private final CustomizedJpaRepository customizedCrudRepository;

    public Controller(CustomizedJpaRepository customizedCrudRepository) {
        this.customizedCrudRepository = customizedCrudRepository;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        List<Person> people = customizedCrudRepository.findByCityOfLiving(city);
        return people;
    }

    @GetMapping("/persons/by-age")
    public List<Person> getPersonsByAge(@RequestParam int age) {
        List<Person> people = customizedCrudRepository.findByAge(age);
        return people;
    }

    @GetMapping("/persons/by-name-and-surname")
    public Optional<Person> getPersonsByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        Optional<Person> people = customizedCrudRepository.findByNameAndSurname(name, surname);
        return people;
    }
}