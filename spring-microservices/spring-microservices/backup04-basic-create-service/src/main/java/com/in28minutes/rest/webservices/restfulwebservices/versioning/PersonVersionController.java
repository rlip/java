package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersionController {

//    Można tak
//    @GetMapping(value="/v1/person")
//    @GetMapping(value="/v2/person")

    /////Params -/person/param?version=1
    @GetMapping(value="/person/param", params="version=1")
    public PersonV1 paramV1() {
        return new PersonV1("Bob Charlie");
    }
    @GetMapping(value="/person/param", params="version=2")
    public PersonV2 paramV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    ////Headers - po prostu do hedera
    @GetMapping(value="/person/header", headers="X-API-VERSION=1")
    public PersonV1 headerV1() {
        return new PersonV1("Bob Charlie");
    }
    @GetMapping(value="/person/header", headers="X-API-VERSION=2")
    public PersonV2 headerV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    ////Produces - to do Accept Header
    @GetMapping(value="/person/produces", produces="application/vnd.company.app-v1+json")
    public PersonV1 producesV1() {
        return new PersonV1("Bob Charlie");
    }
    @GetMapping(value="/person/produces",  produces="application/vnd.company.app-v2+json")
    public PersonV2 producesV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }
}
