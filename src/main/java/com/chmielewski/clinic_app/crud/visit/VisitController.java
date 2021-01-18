package com.chmielewski.clinic_app.crud.visit;

import com.chmielewski.clinic_app.crud.abstracts.AbstractController;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/visits")
public class VisitController extends AbstractController<VisitService, VisitDto> {

    private final VisitService visitService;

    protected VisitController(VisitService service, VisitService visitService) {
        super(service);
        this.visitService = visitService;
    }


    @GetMapping(path = "/user/{id}")
    public Page<VisitDto> getVisitsByUserId(@PathVariable("id") Long userId){
        return visitService.findVisitsByUserId(userId);
    }

}
