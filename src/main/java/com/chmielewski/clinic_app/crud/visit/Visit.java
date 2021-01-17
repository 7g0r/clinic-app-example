package com.chmielewski.clinic_app.crud.visit;

import com.chmielewski.clinic_app.crud.abstracts.AbstractEntity;
import com.chmielewski.clinic_app.crud.doctor.Doctor;
import com.chmielewski.clinic_app.crud.user.User;
import com.chmielewski.clinic_app.utils.VisitStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

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

    @Enumerated(EnumType.STRING)
    private VisitStatus status;

    @JsonFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(dataType = "java.sql.Date")
    private LocalDate visitSarts;

    @JsonFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(dataType = "java.sql.Date")
    private LocalDate visitEnds;


    public static final class VisitBuilder {
        private Long id;
        private Doctor doctor;
        private User user;
        private VisitStatus status;
        private LocalDate visitSarts;
        private LocalDate visitEnds;

        private VisitBuilder() {
        }

        public static VisitBuilder aVisit() {
            return new VisitBuilder();
        }

        public VisitBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public VisitBuilder withDoctor(Doctor doctor) {
            this.doctor = doctor;
            return this;
        }

        public VisitBuilder withUser(User user) {
            this.user = user;
            return this;
        }

        public VisitBuilder withStatus(VisitStatus status) {
            this.status = status;
            return this;
        }

        public VisitBuilder withVisitSarts(LocalDate visitSarts) {
            this.visitSarts = visitSarts;
            return this;
        }

        public VisitBuilder withVisitEnds(LocalDate visitEnds) {
            this.visitEnds = visitEnds;
            return this;
        }

        public Visit build() {
            Visit visit = new Visit();
            visit.setId(id);
            visit.setDoctor(doctor);
            visit.setUser(user);
            visit.setStatus(status);
            visit.setVisitSarts(visitSarts);
            visit.setVisitEnds(visitEnds);
            return visit;
        }
    }
}
