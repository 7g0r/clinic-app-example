package com.chmielewski.clinic_app.crud.abstracts;

import com.chmielewski.clinic_app.exception.NotFoundException;
import com.chmielewski.clinic_app.exception.WrongIdException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public abstract class AbstractService<E extends AbstractEntity, D extends AbstractDto> implements CommonService<D> {

    private final CommonMapper<E, D> commonMapper;
    private final CommonRepository<E> commonRepository;

    protected AbstractService(final CommonMapper<E, D> commonMapper, final CommonRepository<E> commonRepository) {
        this.commonMapper = commonMapper;
        this.commonRepository = commonRepository;
    }

    @Override
    @Transactional
    public Page<D> getAll(Pageable pageable) {
        Page<E> result = commonRepository.findAll(pageable);
        List<D> content = commonMapper.toListDto(result.getContent());
        return new PageImpl<>(content, pageable, result.getTotalElements());
    }

    @Override
    @Transactional
    public D findById(Long id) {
        E entity = getEntityById(id);
        return commonMapper.toDto(entity);
    }

    @Transactional
    public E getEntityById(Long id) {
        return commonRepository.findById(id).orElseThrow(() -> new NotFoundException(id, "entityName"));
    }

    @Override
    @Transactional
    public D save(D dto) {
        E entity = commonMapper.fromDto(dto);
        E savedResult = commonRepository.saveAndFlush(entity);
        return commonMapper.toDto(savedResult);
    }

    @Override
    @Transactional
    public D update(Long id, D dto) {
        if (id < 1 || !dto.getId().equals(id)) {
            throw new WrongIdException(id);
        }
        getEntityById(id);
        E entity = commonMapper.fromDto(dto);
        E result = commonRepository.saveAndFlush(entity);
        return commonMapper.toDto(result);
    }

    @Override
    @Transactional
    public D delete(Long id) {
        E entity = getEntityById(id);
        commonRepository.deleteById(entity.getId());
        return commonMapper.toDto(entity);
    }

}
