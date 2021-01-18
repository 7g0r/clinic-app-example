package com.chmielewski.clinic_app.crud.visit;

import com.chmielewski.clinic_app.crud.abstracts.AbstractDto;
import com.chmielewski.clinic_app.crud.doctor.DoctorDto;
import com.chmielewski.clinic_app.crud.user.UserDto;
import com.chmielewski.clinic_app.utils.VisitStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class VisitDto extends AbstractDto {

    private DoctorDto doctorDto;
    private UserDto userDto;
    private VisitStatus status;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("date")
    private LocalDateTime visitDate;

    public static final class VisitDtoBuilder {
        private Long id;
        private DoctorDto doctorDto;
        private UserDto userDto;
        private VisitStatus status;
        private LocalDateTime visitDate;

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

        public VisitDtoBuilder withVisitDate(LocalDateTime visitDate) {
            this.visitDate = visitDate;
            return this;
        }

        public VisitDto build() {
            VisitDto visitDto = new VisitDto();
            visitDto.setId(id);
            visitDto.setDoctorDto(doctorDto);
            visitDto.setUserDto(userDto);
            visitDto.setStatus(status);
            visitDto.setVisitDate(visitDate);
            return visitDto;
        }
    }

    /*@JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime visitStartTime;*/



}
