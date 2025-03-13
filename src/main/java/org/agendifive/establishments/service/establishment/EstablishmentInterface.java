package org.agendifive.establishments.service.establishment;

import org.agendifive.establishments.model.establishment.EstablishmentRequest;
import org.agendifive.establishments.model.establishment.ResponseStablishment;

public interface EstablishmentInterface {

    ResponseStablishment saveEstablishment(EstablishmentRequest request);
    ResponseStablishment getActiveEstablishments();
}
