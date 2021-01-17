package com.chmielewski.clinic_app.crud.doctor;

import com.chmielewski.clinic_app.crud.abstracts.AbstractEntity;
import com.chmielewski.clinic_app.crud.visit.Visit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "doctors")
@NoArgsConstructor
@Setter
@Getter
public class Doctor extends AbstractEntity {

    private String name;

    private String secondName;

    @OneToMany(mappedBy = "doctor", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Set<Visit> visits;


    public static final class DoctorBuilder {
        private Long id;
        private String name;
        private String secondName;
        private Set<Visit> visits;

        private DoctorBuilder() {
        }

        public static DoctorBuilder aDoctor() {
            return new DoctorBuilder();
        }

        public DoctorBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public DoctorBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public DoctorBuilder withSecondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public DoctorBuilder withVisits(Set<Visit> visits) {
            this.visits = visits;
            return this;
        }

        public Doctor build() {
            Doctor doctor = new Doctor();
            doctor.setId(id);
            doctor.setName(name);
            doctor.setSecondName(secondName);
            doctor.setVisits(visits);
            return doctor;
        }
    }
}
