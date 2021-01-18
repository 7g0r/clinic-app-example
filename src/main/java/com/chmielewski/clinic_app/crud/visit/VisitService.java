package com.chmielewski.clinic_app.crud.visit;

import com.chmielewski.clinic_app.crud.abstracts.CommonService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface VisitService extends CommonService<VisitDto> {

    Page<VisitDto>findVisitsByUserId(Long userId);


}
