package org.agendifive.establishments.service.businessservices;

import org.agendifive.establishments.model.businessservices.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Services, Long> {
    List<Services> findByStatus(char status);
}
