package com.chmielewski.clinic_app.crud.user;

import com.chmielewski.clinic_app.crud.abstracts.AbstractController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserControllers extends AbstractController<UserService, UserDto> {
    protected UserControllers(UserService service) {
        super(service);
    }
}
