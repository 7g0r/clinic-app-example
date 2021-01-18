package com.chmielewski.clinic_app.crud.visit;

import com.chmielewski.clinic_app.crud.abstracts.AbstractDto;
import com.chmielewski.clinic_app.crud.doctor.DoctorDto;
import com.chmielewski.clinic_app.crud.user.UserDto;
import com.chmielewski.clinic_app.utils.VisitStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class VisitDto extends AbstractDto {

    private DoctorDto doctorDto;
    private UserDto userDto;
    private VisitStatus status;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate visitStarts;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate visitEnds;


    public static final class VisitDtoBuilder {
        private Long id;
        private DoctorDto doctorDto;
        private UserDto userDto;
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

        public VisitDtoBuilder withDoctorDto(DoctorDto doctorDto) {
            this.doctorDto = doctorDto;
            return this;
        }

        public VisitDtoBuilder withUserDto(UserDto userDto) {
            this.userDto = userDto;
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
            visitDto.setDoctorDto(doctorDto);
            visitDto.setUserDto(userDto);
            visitDto.setStatus(status);
            visitDto.setVisitStarts(visitStarts);
            visitDto.setVisitEnds(visitEnds);
            return visitDto;
        }
    }
}
