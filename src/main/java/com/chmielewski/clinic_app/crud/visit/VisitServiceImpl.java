package com.chmielewski.clinic_app.crud.visit;

import com.chmielewski.clinic_app.crud.abstracts.AbstractService;
import com.chmielewski.clinic_app.crud.abstracts.CommonMapper;
import com.chmielewski.clinic_app.crud.abstracts.CommonRepository;
import com.chmielewski.clinic_app.crud.user.User;
import com.chmielewski.clinic_app.crud.user.UserRepository;
import com.chmielewski.clinic_app.exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitServiceImpl extends AbstractService<Visit, VisitDto> implements VisitService {
    private final VisitMapper visitMapper;
    private final VisitRepository visitRepository;
    private final UserRepository userRepository;

    protected VisitServiceImpl(CommonMapper<Visit, VisitDto> commonMapper, CommonRepository<Visit> commonRepository, VisitMapper visitMapper, VisitRepository visitRepository, UserRepository userRepository) {
        super(commonMapper, commonRepository);
        this.visitMapper = visitMapper;
        this.visitRepository = visitRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Page<VisitDto> findVisitsByUserId(Long userId) {
       userRepository.findById(userId).orElseThrow(()-> new NotFoundException(userId, User.class.getSimpleName()));
       List<Visit> visits = visitRepository.findVisitByUserId(userId);
       return new PageImpl<>(visitMapper.toListDto(visits));
    }
}
