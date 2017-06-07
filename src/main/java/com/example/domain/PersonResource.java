package com.example.domain;

import com.example.controller.HateoasController;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class PersonResource extends ResourceSupport {

    private final Person payload;

    public PersonResource(Person payload) {
        this.payload = payload;
    }

    public PersonResource withSelfLink() {
        this.add(ControllerLinkBuilder.linkTo(methodOn(HateoasController.class)
                .getOne(payload.getName())).withSelfRel());
        return this;
    }

    public Person getPayload() {
        return payload;
    }
}
