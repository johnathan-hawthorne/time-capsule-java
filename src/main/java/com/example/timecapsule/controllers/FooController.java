package com.example.timecapsule.controllers;

import com.example.timecapsule.beans.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

class FooService {
    public List<Foo> findAll() {
        return null;
    }
}

@RestController
@RequestMapping("/foos")
class FooController {

    @Autowired
    private Foo foo;

//    @GetMapping(value = "/")
//    public List<Foo> findAll() {
//        FooService service = new FooService();
//        return service.findAll();
//    }

    @GetMapping(value = "/{id}")
    public Object findById(@PathVariable("id") Long id) {
        return "Hello World" + foo;
    }

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Long create(@RequestBody Foo resource) {
//        Preconditions.checkNotNull(resource);
//        return service.create(resource);
//    }
//
//    @PutMapping(value = "/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public void update(@PathVariable( "id" ) Long id, @RequestBody Foo resource) {
//        Preconditions.checkNotNull(resource);
//        RestPreconditions.checkNotNull(service.getById(resource.getId()));
//        service.update(resource);
//    }
//
//    @DeleteMapping(value = "/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public void delete(@PathVariable("id") Long id) {
//        service.deleteById(id);
//    }

}