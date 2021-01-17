package com.chmielewski.clinic_app.crud.doctor;

import com.chmielewski.clinic_app.crud.abstracts.AbstractController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Doctors")
public class DoctorController extends AbstractController<DoctorService, DoctorDto> {

    protected DoctorController(DoctorService service) {
        super(service);
    }
}
