package io.abdul.userserviceemails.repository;

import io.abdul.userserviceemails.domain.Confirmation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmationRepository extends JpaRepository<Confirmation, Long> {
    Confirmation findByToken(String token);
}
