package com.chmielewski.clinic_app.crud.abstracts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public abstract class AbstractController<T extends CommonService<D>, D extends AbstractDto> {

    private final T service;

    protected AbstractController(T service) {
        this.service = service;
    }

    @GetMapping
    Page<D> findAll(@PageableDefault Pageable pageable) {
        return service.getAll(pageable);
    }

    @GetMapping(path = "/{id}")
    D findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    D save(@RequestBody @Valid D dto) {
        return service.save(dto);
    }

    @PutMapping(path = "/{id}")
    D update(@PathVariable("id") Long id, @RequestBody @Valid D dto) {
        return service.update(id, dto);
    }

    @DeleteMapping(path = "/{id}")
    D delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }
}
