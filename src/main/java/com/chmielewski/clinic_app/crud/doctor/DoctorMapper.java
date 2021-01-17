package com.chmielewski.clinic_app.crud.doctor;

import com.chmielewski.clinic_app.crud.abstracts.CommonMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DoctorMapper extends CommonMapper<Doctor, DoctorDto> {
    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);


}
