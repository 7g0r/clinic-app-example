package com.chmielewski.clinic_app.crud.visit;

import com.chmielewski.clinic_app.crud.abstracts.CommonRepository;
import com.chmielewski.clinic_app.utils.VisitStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface VisitRepository extends CommonRepository<Visit> {

    List<Visit> findVisitByUserId(Long userId);

    List<Visit> findAllByDoctorId(Long doctorId);

    @Query(value = "SELECT * FROM VISITS WHERE FORMATDATETIME(VISIT_DATE,'yyyy-MM-dd') =:date AND DOCTORS_ID =:doctorId", nativeQuery = true)
    List<Visit> findByVisitDateAndDoctor(LocalDate date, Long doctorId);

    Optional<Visit> findByDoctorIdAndVisitDateBetweenAndStatus(Long id, LocalDateTime startDate, LocalDateTime endDay, VisitStatus status);

    List<Visit> findAllByStatusAndVisitDateBefore(VisitStatus status, LocalDateTime date);
}
