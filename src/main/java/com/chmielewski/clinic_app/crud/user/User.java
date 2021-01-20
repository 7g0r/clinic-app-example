package com.chmielewski.clinic_app.crud.user;

import com.chmielewski.clinic_app.crud.abstracts.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User extends AbstractEntity {

    private String name;
    private String secondName;
    private Long pin;
}

