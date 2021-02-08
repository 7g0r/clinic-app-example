package com.chmielewski.clinic_app.crud.visit;

import com.chmielewski.clinic_app.crud.abstracts.AbstractService;
import com.chmielewski.clinic_app.crud.abstracts.CommonMapper;
import com.chmielewski.clinic_app.crud.abstracts.CommonRepository;
import com.chmielewski.clinic_app.crud.doctor.Doctor;
import com.chmielewski.clinic_app.crud.doctor.DoctorRepository;
import com.chmielewski.clinic_app.crud.user.User;
import com.chmielewski.clinic_app.crud.user.UserRepository;
import com.chmielewski.clinic_app.exception.DoctorBusyException;
import com.chmielewski.clinic_app.exception.NotFoundException;
import com.chmielewski.clinic_app.exception.WrongAuthDataException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.chmielewski.clinic_app.utils.VisitStatus.*;

@Service
public class VisitServiceImpl extends AbstractService<Visit, VisitDto> implements VisitService {
    private final VisitMapper visitMapper;
    private final VisitRepository visitRepository;
    private final UserRepository userRepository;
    private final DoctorRepository doctorRepository;

    protected VisitServiceImpl(CommonMapper<Visit, VisitDto> commonMapper, CommonRepository<Visit> commonRepository,
                               VisitMapper visitMapper, VisitRepository visitRepository, UserRepository userRepository,
                               DoctorRepository doctorRepository) {
        super(commonMapper, commonRepository);
        this.visitMapper = visitMapper;
        this.visitRepository = visitRepository;
        this.userRepository = userRepository;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public VisitDto save(VisitDto dto) {
        userRepository.findByIdAndPin(dto.getUserId(), dto.getPin()).orElseThrow(WrongAuthDataException::new);
        visitRepository.findByDoctorIdAndVisitDateBetweenAndStatus(dto.getDoctorId(), dto.getVisitDate().minusMinutes(30),
                dto.getVisitDate().plusMinutes(30), ARRANGED)
                .ifPresent((s) -> {
                    throw new DoctorBusyException();
                });
        return visitMapper.toDto(visitRepository.save(visitMapper.fromDto(dto)));
    }

    @Override
    public Page<VisitDto> findVisitsByUserId(Long userId) {
        userRepository.findById(userId).orElseThrow(() -> new NotFoundException(userId, User.class.getSimpleName()));
        List<Visit> visits = visitRepository.findVisitByUserId(userId);
        return new PageImpl<>(visitMapper.toListDto(visits));
    }

    @Override
    public Page<VisitDto> findVisitsByDoctorId(Long doctorId) {
        doctorRepository.findById(doctorId).orElseThrow(() -> new NotFoundException(doctorId, Doctor.class.getSimpleName()));
        List<Visit> visits = visitRepository.findAllByDoctorId(doctorId);
        return new PageImpl<>(visitMapper.toListDto(visits));
    }

    @Override
    public Page<VisitDto> findVisitsByDoctorIdAndDate(Long doctorId, LocalDate date) {
        doctorRepository.findById(doctorId).orElseThrow(() -> new NotFoundException(doctorId, Doctor.class.getSimpleName()));
        List<Visit> visits = visitRepository.findByVisitDateAndDoctor(date, doctorId);
        return new PageImpl<>(visitMapper.toListDto(visits));
    }

    @Override
    public void changeStatus(Long visitId, Long userId, Long pin) {
        Visit visit = visitRepository.findById(visitId).orElseThrow(() -> new NotFoundException(visitId, Visit.class.getSimpleName()));
        if (visit.getUser().getId().equals(userId) && visit.getUser().getPin().equals(pin)) {
            visit.setStatus(CANCELED);
            visitRepository.save(visit);
        } else {
            throw new WrongAuthDataException();
        }
    }
    @Scheduled(cron = "0 0/30 * * * MON-FRI")
    public void updateVisitsStatuses(){
        visitRepository.saveAll(visitRepository.findAllByStatusAndVisitDateBefore(ARRANGED, LocalDateTime.now().minusMinutes(30))
                .stream()
                .peek(element -> element.setStatus(FINISHED))
                .collect(Collectors.toList()));
    }
}
