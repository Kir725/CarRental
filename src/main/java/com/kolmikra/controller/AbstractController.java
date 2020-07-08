package com.kolmikra.controller;

import com.kolmikra.exception.NoSuchItemException;
import com.kolmikra.entity.AbstractEntity;
import com.kolmikra.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
public abstract class AbstractController<E extends AbstractEntity, S extends CommonService<E>> {

    private final S service;

    @Autowired
    public AbstractController(S service) {
        this.service = service;
    }

    @CrossOrigin
    @GetMapping("/find/{id}")
    public ResponseEntity<E> findById(@PathVariable int id) {
        try {
            E entity = service.findById(id);
            return ResponseEntity.ok(entity);
        } catch (NoSuchItemException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/find/all/{typeId}")
    public List<E> findAll(@PathVariable int typeId) {
        return service.findAll(typeId);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public HttpStatus delete(@PathVariable int id) {
        try {
            service.deleteById(id);
            return HttpStatus.OK;
        } catch (NoSuchItemException e) {
            return HttpStatus.NOT_FOUND;
        }
    }

    @CrossOrigin
    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public E create(@RequestBody E entity) {
        return service.create(entity);
    }


    @PutMapping("/update/{id}")
    @CrossOrigin
    public ResponseEntity<E> update(@PathVariable int id, @RequestBody E entity) {
        try {
            E updated = service.updateById(id, entity);
            return ResponseEntity.ok(updated);
        } catch (NoSuchItemException e) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }
}
