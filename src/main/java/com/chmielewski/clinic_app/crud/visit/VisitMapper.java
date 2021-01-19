package com.chmielewski.clinic_app.crud.visit;

import com.chmielewski.clinic_app.crud.abstracts.CommonMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VisitMapper extends CommonMapper<Visit, VisitDto> {
    VisitMapper INSTANCE = Mappers.getMapper(VisitMapper.class);

    @Override
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "doctor.id",target = "doctorId")
    VisitDto toDto(Visit visit);

    @Override
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "doctorId", target ="doctor.id" )
    Visit fromDto(VisitDto dto);
}
