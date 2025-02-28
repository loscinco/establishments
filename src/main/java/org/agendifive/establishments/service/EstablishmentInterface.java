package org.agendifive.establishments.service;

import org.agendifive.establishments.model.EstablishmentRequest;
import org.agendifive.establishments.model.ResponseStablishment;

public interface EstablishmentInterface {

    ResponseStablishment saveEstablishment(EstablishmentRequest request);
    ResponseStablishment getActiveEstablishments();
}
