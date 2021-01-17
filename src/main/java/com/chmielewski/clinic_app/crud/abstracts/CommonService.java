package com.chmielewski.clinic_app.crud.abstracts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommonService<D extends AbstractDto> {
    Page<D> getAll(Pageable pageable);

    D findById(Long id);

    D save(D dto);

    D update(Long id, D dto);

    D delete(Long id);
}
