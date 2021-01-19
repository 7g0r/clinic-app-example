package com.chmielewski.clinic_app.crud.visit;

import com.chmielewski.clinic_app.crud.abstracts.CommonService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public interface VisitService extends CommonService<VisitDto> {

    Page<VisitDto>findVisitsByUserId(Long userId);

    Page<VisitDto>findVisitsByDoctorId(Long doctorId);

    Page<VisitDto> findVisitsByDoctorIdAndDate(Long doctorId, LocalDate date);

    void changeStatus(Long visitId, Long userId, Long pin);

}
