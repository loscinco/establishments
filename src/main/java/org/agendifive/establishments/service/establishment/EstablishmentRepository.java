package org.agendifive.establishments.service.establishment;

import org.agendifive.establishments.model.establishment.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstablishmentRepository extends JpaRepository<Establishment, Long> {


    Optional<Establishment> findByNitRut(String nitRut);

    List<Establishment> findByStatus(String status);
}