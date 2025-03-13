package org.agendifive.establishments.service.businessservices;

import org.agendifive.establishments.model.businessservices.ResponseBusinessServices;
import org.agendifive.establishments.model.businessservices.Services;
import org.agendifive.establishments.service.businessservices.BusinessServicesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessServicesService implements BusinessServicesInterface {

    @Autowired
    private ServiceRepository serviceRepository;
    @Override
    public ResponseBusinessServices getServices() {
        List<Services> activeServices = serviceRepository.findByStatus('A');
        ResponseBusinessServices response = new ResponseBusinessServices();
        response.setSuccess(false);
        response.setMessage("No es posible obtener los servicios");
        if(activeServices.size() > 0){
            response.setSuccess(true);
            response.setMessage("Servicios obtenidos correctamente");
            response.setData(activeServices);
        }
        return response;
    }
}
