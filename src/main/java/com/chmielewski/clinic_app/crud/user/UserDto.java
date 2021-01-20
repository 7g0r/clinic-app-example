package com.chmielewski.clinic_app.crud.user;

import com.chmielewski.clinic_app.crud.abstracts.AbstractDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto extends AbstractDto {

    private String name;
    private String secondName;
    private Long pin;
}
