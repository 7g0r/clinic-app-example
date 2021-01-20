package com.chmielewski.clinic_app.crud.user;

import com.chmielewski.clinic_app.crud.abstracts.CommonRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CommonRepository<User> {

    Optional<User> findByIdAndPin(Long id, Long pin);
}
