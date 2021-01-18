package com.chmielewski.clinic_app.crud.visit;

import com.chmielewski.clinic_app.crud.abstracts.CommonMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VisitMapper extends CommonMapper<Visit, VisitDto> {
    VisitMapper INSTANCE = Mappers.getMapper(VisitMapper.class);

    @Override
    @Mapping(source = "user", target = "userDto")
    @Mapping(source = "doctor",target = "doctorDto")
    VisitDto toDto(Visit visit);

    @Override
    @Mapping(source = "userDto", target = "user")
    @Mapping(source = "doctorDto", target ="doctor" )
    Visit fromDto(VisitDto dto);
}
