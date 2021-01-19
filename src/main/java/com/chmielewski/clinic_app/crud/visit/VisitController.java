package com.chmielewski.clinic_app.crud.visit;

import com.chmielewski.clinic_app.crud.abstracts.AbstractController;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/api/visits")
public class VisitController extends AbstractController<VisitService, VisitDto> {

    private final VisitService visitService;

    protected VisitController(VisitService service, VisitService visitService) {
        super(service);
        this.visitService = visitService;
    }


    @GetMapping(path = "/user/{id}")
    public Page<VisitDto> getVisitsByUserId(@PathVariable("id") Long userId) {
        return visitService.findVisitsByUserId(userId);
    }

    @GetMapping(path = "/doctor/{id}")
    public Page<VisitDto> getVisitsByDoctorId(@PathVariable("id") Long doctorId) {
        return visitService.findVisitsByDoctorId(doctorId);
    }

    @GetMapping(path = "/date/{id}")
    public Page<VisitDto> getVisitsByDateAndDoctorId(@PathVariable("id") Long doctorId, @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return visitService.findVisitsByDoctorIdAndDate(doctorId, date);
    }

    @GetMapping(path = "/{id}/cancel")
    public void cancelVisit(@PathVariable("id") Long id, @RequestParam("userId") Long userId, @RequestParam("pin") Long pin) {
        visitService.changeStatus(id, userId, pin);
    }

}
