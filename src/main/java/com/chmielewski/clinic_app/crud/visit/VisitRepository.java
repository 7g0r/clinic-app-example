package com.chmielewski.clinic_app.crud.visit;

import com.chmielewski.clinic_app.crud.abstracts.CommonRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface VisitRepository extends CommonRepository<Visit> {

    List<Visit> findVisitByUserId(Long userId);

    List<Visit> findAllByDoctorId(Long doctorId);

    List<Visit> findAllByDoctorIdAndVisitStarts(Long doctorId, LocalDate date);
}
