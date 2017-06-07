package com.example.controller;

import com.example.domain.Person;
import com.example.domain.PersonResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class HateoasController {

    @GetMapping(value = "/api/people/{name}")
    public PersonResource getOne(@PathVariable(name = "name") String name) {
        return new PersonResource(new Person(name, 25)).withSelfLink();
    }

    @GetMapping(value = "/api/people")
    public List<PersonResource> getAll() {
        List<Person> people = Arrays.asList(new Person("person1", 21), new Person("person2", 32),
                new Person("person3", 16));
        return people.stream()
                     .map(PersonResource::new)
                     .map(PersonResource::withSelfLink)
                     .collect(Collectors.toList());
    }

}
