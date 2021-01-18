package com.chmielewski.clinic_app.crud.doctor;

import com.chmielewski.clinic_app.crud.abstracts.AbstractDto;
import com.chmielewski.clinic_app.crud.visit.VisitDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class DoctorDto extends AbstractDto {

    @NotBlank(message = "Doctor's name must not be null or empty")
    private String name;

    @NotBlank(message = "Doctor's second name must not be null or empty")
    private String secondName;


    public static final class DoctorDtoBuilder {
        private Long id;
        private String name;
        private String secondName;

        private DoctorDtoBuilder() {
        }

        public static DoctorDtoBuilder aDoctorDto() {
            return new DoctorDtoBuilder();
        }

        public DoctorDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public DoctorDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public DoctorDtoBuilder withSecondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public DoctorDto build() {
            DoctorDto doctorDto = new DoctorDto();
            doctorDto.setId(id);
            doctorDto.setName(name);
            doctorDto.setSecondName(secondName);
            return doctorDto;
        }
    }
}
