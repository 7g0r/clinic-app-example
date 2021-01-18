package com.chmielewski.clinic_app.crud.visit;

import com.chmielewski.clinic_app.crud.abstracts.AbstractService;
import com.chmielewski.clinic_app.crud.abstracts.CommonMapper;
import com.chmielewski.clinic_app.crud.abstracts.CommonRepository;
import com.chmielewski.clinic_app.crud.doctor.Doctor;
import com.chmielewski.clinic_app.crud.doctor.DoctorRepository;
import com.chmielewski.clinic_app.crud.user.User;
import com.chmielewski.clinic_app.crud.user.UserRepository;
import com.chmielewski.clinic_app.exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VisitServiceImpl extends AbstractService<Visit, VisitDto> implements VisitService {
    private final VisitMapper visitMapper;
    private final VisitRepository visitRepository;
    private final UserRepository userRepository;
    private final DoctorRepository doctorRepository;

    protected VisitServiceImpl(CommonMapper<Visit, VisitDto> commonMapper, CommonRepository<Visit> commonRepository, VisitMapper visitMapper, VisitRepository visitRepository, UserRepository userRepository, DoctorRepository doctorRepository) {
        super(commonMapper, commonRepository);
        this.visitMapper = visitMapper;
        this.visitRepository = visitRepository;
        this.userRepository = userRepository;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Page<VisitDto> findVisitsByUserId(Long userId) {
       userRepository.findById(userId).orElseThrow(()-> new NotFoundException(userId, User.class.getSimpleName()));
       List<Visit> visits = visitRepository.findVisitByUserId(userId);
       return new PageImpl<>(visitMapper.toListDto(visits));
    }

    @Override
    public Page<VisitDto> findVisitsByDoctorId(Long doctorId) {
        doctorRepository.findById(doctorId).orElseThrow(()-> new NotFoundException(doctorId, Doctor.class.getSimpleName()));
        List<Visit> visits = visitRepository.findAllByDoctorId(doctorId);
        return new PageImpl<>(visitMapper.toListDto(visits));
    }

    @Override
    public Page<VisitDto> findVisitsByDoctorIdAndDate(Long doctorId, LocalDate date) {
        doctorRepository.findById(doctorId).orElseThrow(()-> new NotFoundException(doctorId, Doctor.class.getSimpleName()));
        List<Visit> visits = visitRepository.findByVisitDateAndDoctor(date,doctorId);
        return new PageImpl<>(visitMapper.toListDto(visits));
    }
}
