package com.chmielewski.clinic_app.crud.doctor;

import com.chmielewski.clinic_app.crud.abstracts.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "doctors")
@NoArgsConstructor
@Setter
@Getter
public class Doctor extends AbstractEntity {

    private String name;
    private String secondName;
}
