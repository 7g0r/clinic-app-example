package com.chmielewski.clinic_app.crud.user;

import com.chmielewski.clinic_app.crud.abstracts.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="users")
@NoArgsConstructor
@Getter
@Setter
public class User extends AbstractEntity {

    private String Pin;


    public static final class UserBuilder {
        private Long id;
        private String Pin;

        private UserBuilder() {
        }

        public static UserBuilder anUser() {
            return new UserBuilder();
        }

        public UserBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder withPin(String Pin) {
            this.Pin = Pin;
            return this;
        }

        public User build() {
            User user = new User();
            user.setId(id);
            user.setPin(Pin);
            return user;
        }
    }
}
