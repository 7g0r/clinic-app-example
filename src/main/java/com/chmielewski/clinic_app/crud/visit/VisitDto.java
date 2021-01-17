package com.chmielewski.clinic_app.crud.visit;

import com.chmielewski.clinic_app.crud.abstracts.AbstractDto;
import com.chmielewski.clinic_app.crud.doctor.DoctorDto;
import com.chmielewski.clinic_app.crud.user.UserDto;
import com.chmielewski.clinic_app.utils.VisitStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class VisitDto extends AbstractDto {

    private DoctorDto doctor;
    private UserDto user;
    private VisitStatus status;
    private LocalDate visitStarts;
    private LocalDate visitEnds;


    public static final class VisitDtoBuilder {
        private Long id;
        private DoctorDto doctor;
        private UserDto user;
        private VisitStatus status;
        private LocalDate visitStarts;
        private LocalDate visitEnds;

        private VisitDtoBuilder() {
        }

        public static VisitDtoBuilder aVisitDto() {
            return new VisitDtoBuilder();
        }

        public VisitDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public VisitDtoBuilder withDoctor(DoctorDto doctor) {
            this.doctor = doctor;
            return this;
        }

        public VisitDtoBuilder withUser(UserDto user) {
            this.user = user;
            return this;
        }

        public VisitDtoBuilder withStatus(VisitStatus status) {
            this.status = status;
            return this;
        }

        public VisitDtoBuilder withVisitStarts(LocalDate visitStarts) {
            this.visitStarts = visitStarts;
            return this;
        }

        public VisitDtoBuilder withVisitEnds(LocalDate visitEnds) {
            this.visitEnds = visitEnds;
            return this;
        }

        public VisitDto build() {
            VisitDto visitDto = new VisitDto();
            visitDto.setId(id);
            visitDto.setDoctor(doctor);
            visitDto.setUser(user);
            visitDto.setStatus(status);
            visitDto.setVisitStarts(visitStarts);
            visitDto.setVisitEnds(visitEnds);
            return visitDto;
        }
    }
}
