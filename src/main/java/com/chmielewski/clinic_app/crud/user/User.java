package com.chmielewski.clinic_app.crud.user;

import com.chmielewski.clinic_app.crud.abstracts.AbstractEntity;
import com.chmielewski.clinic_app.crud.visit.Visit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User extends AbstractEntity {

    private String name;
    private String secondName;
    private Long pin;


    public static final class UserBuilder {
        private Long id;
        private String name;
        private String secondName;
        private Long pin;

        private UserBuilder() {
        }

        public static UserBuilder anUser() {
            return new UserBuilder();
        }

        public UserBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder withSecondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public UserBuilder withPin(Long pin) {
            this.pin = pin;
            return this;
        }

        public User build() {
            User user = new User();
            user.setId(id);
            user.setName(name);
            user.setSecondName(secondName);
            user.setPin(pin);
            return user;
        }
    }
}

