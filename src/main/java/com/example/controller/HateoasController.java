package com.example.controller;

import com.example.domain.Person;
import com.example.domain.PersonResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class HateoasController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/api/people/{name}")
    public PersonResource getOne(@PathVariable(name = "name") String name) {
        log.debug("getting one person...");
        return new PersonResource(new Person(name, 123)).withSelfLink();
    }

    private Map<String, String> getHeadersInfo(HttpServletRequest request) {

        Map<String, String> map = new HashMap<>();

        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }

        return map;
    }

    @GetMapping(value = "/api/people")
    public List<PersonResource> getAll() {
        log.warn("getting all persons...");
        List<Person> people = Arrays.asList(new Person("person1", 21), new Person("person2", 32),
                new Person("person3", 16));
        return people.stream()
                     .map(PersonResource::new)
                     .map(PersonResource::withSelfLink)
                     .collect(Collectors.toList());
    }

    @GetMapping(value = "/api/test")
    public String test() {
        return "Location: com";
    }

}
