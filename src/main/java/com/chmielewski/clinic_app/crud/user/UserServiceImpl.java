package com.chmielewski.clinic_app.crud.user;

import com.chmielewski.clinic_app.crud.abstracts.AbstractService;
import com.chmielewski.clinic_app.crud.abstracts.CommonMapper;
import com.chmielewski.clinic_app.crud.abstracts.CommonRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractService<User, UserDto> implements UserService {

    protected UserServiceImpl(CommonMapper<User, UserDto> commonMapper, CommonRepository<User> commonRepository) {
        super(commonMapper, commonRepository);
    }
}
