package com.chmielewski.clinic_app.crud.visit;

import com.chmielewski.clinic_app.crud.abstracts.CommonMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VisitMapper extends CommonMapper<Visit, VisitDto> {
    VisitMapper INSTANCE = Mappers.getMapper(VisitMapper.class);
}
