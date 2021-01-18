package com.chmielewski.clinic_app.crud.visit;

import com.chmielewski.clinic_app.crud.abstracts.CommonRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VisitRepository extends CommonRepository<Visit> {

    List<Visit> findVisitByUserId(Long userId);

    List<Visit> findAllByDoctorId(Long doctorId);

    List<Visit> findAllByDoctorIdAndVisitDate(Long doctorId, LocalDateTime date);

    @Query(value = "SELECT * FROM VISITS WHERE FORMATDATETIME(VISIT_DATE,'yyyy-MM-dd') =:date AND DOCTORS_ID =:doctorId", nativeQuery = true)
    List<Visit>findByVisitDateAndDoctor(LocalDate date, Long doctorId);
}
