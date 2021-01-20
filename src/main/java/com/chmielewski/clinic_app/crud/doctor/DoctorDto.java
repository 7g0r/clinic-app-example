package com.chmielewski.clinic_app.crud.doctor;

import com.chmielewski.clinic_app.crud.abstracts.AbstractDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class DoctorDto extends AbstractDto {

    @NotBlank(message = "Doctor's name must not be null or empty")
    private String name;

    @NotBlank(message = "Doctor's second name must not be null or empty")
    private String secondName;
}
