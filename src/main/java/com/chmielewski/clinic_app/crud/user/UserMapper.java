package com.chmielewski.clinic_app.crud.user;

import com.chmielewski.clinic_app.crud.abstracts.CommonMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper extends CommonMapper<User, UserDto> {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
}
