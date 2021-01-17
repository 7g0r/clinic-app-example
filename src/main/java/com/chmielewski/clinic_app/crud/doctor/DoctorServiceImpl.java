package com.chmielewski.clinic_app.crud.doctor;

import com.chmielewski.clinic_app.crud.abstracts.AbstractService;
import com.chmielewski.clinic_app.crud.abstracts.CommonMapper;
import com.chmielewski.clinic_app.crud.abstracts.CommonRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl extends AbstractService<Doctor, DoctorDto> implements DoctorService {
    protected DoctorServiceImpl(CommonMapper<Doctor, DoctorDto> commonMapper, CommonRepository<Doctor> commonRepository) {
        super(commonMapper, commonRepository);
    }
}
