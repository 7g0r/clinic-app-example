package com.chmielewski.clinic_app.crud.visit;

import com.chmielewski.clinic_app.crud.abstracts.AbstractEntity;
import com.chmielewski.clinic_app.crud.doctor.Doctor;
import com.chmielewski.clinic_app.crud.user.User;
import com.chmielewski.clinic_app.utils.VisitStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

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

    private LocalDate visitStarts;

    private LocalDate visitEnds;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Visit)) return false;
        Visit visit = (Visit) o;
        return Objects.equals(getId(), visit.getId()) &&
                Objects.equals(doctor, visit.doctor) &&
                Objects.equals(user, visit.user) &&
                status == visit.status &&
                Objects.equals(visitStarts, visit.visitStarts) &&
                Objects.equals(visitEnds, visit.visitEnds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public static final class VisitBuilder {
        private Long id;
        private Doctor doctor;
        private User user;
        private VisitStatus status;
        private LocalDate visitStarts;
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

        public VisitBuilder withVisitStarts(LocalDate visitStarts) {
            this.visitStarts = visitStarts;
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
            visit.setVisitStarts(visitStarts);
            visit.setVisitEnds(visitEnds);
            return visit;
        }
    }
}
