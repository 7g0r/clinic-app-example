package com.chmielewski.clinic_app.crud.visit;

import com.chmielewski.clinic_app.crud.abstracts.AbstractService;
import com.chmielewski.clinic_app.crud.abstracts.CommonMapper;
import com.chmielewski.clinic_app.crud.abstracts.CommonRepository;
import org.springframework.stereotype.Service;

@Service
public class VisitServiceImpl extends AbstractService<Visit, VisitDto> implements VisitService {
    protected VisitServiceImpl(CommonMapper<Visit, VisitDto> commonMapper, CommonRepository<Visit> commonRepository) {
        super(commonMapper, commonRepository);
    }
}
