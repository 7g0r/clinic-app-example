package com.chmielewski.clinic_app.crud.user;

import com.chmielewski.clinic_app.crud.abstracts.AbstractDto;
import com.chmielewski.clinic_app.crud.visit.VisitDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserDto extends AbstractDto {


    private String name;
    private String secondName;
    private Long pin;


    public static final class UserDtoBuilder {
        private Long id;
        private String name;
        private String secondName;
        private Long pin;

        private UserDtoBuilder() {
        }

        public static UserDtoBuilder anUserDto() {
            return new UserDtoBuilder();
        }

        public UserDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public UserDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public UserDtoBuilder withSecondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public UserDtoBuilder withPin(Long pin) {
            this.pin = pin;
            return this;
        }

        public UserDto build() {
            UserDto userDto = new UserDto();
            userDto.setId(id);
            userDto.setName(name);
            userDto.setSecondName(secondName);
            userDto.setPin(pin);
            return userDto;
        }
    }
}
