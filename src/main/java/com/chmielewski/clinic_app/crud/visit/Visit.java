package com.chmielewski.clinic_app.crud.visit;

import com.chmielewski.clinic_app.crud.abstracts.AbstractEntity;
import com.chmielewski.clinic_app.crud.doctor.Doctor;
import com.chmielewski.clinic_app.crud.user.User;
import com.chmielewski.clinic_app.utils.VisitStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "visits")
@NoArgsConstructor
@Getter
@Setter
public class Visit extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctors_id")
    private Doctor doctor;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private User user;

    @NotNull
    @Enumerated(EnumType.STRING)
    private VisitStatus status;
    private LocalDateTime visitDate;
}
