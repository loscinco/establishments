package org.agendifive.establishments.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.agendifive.establishments.model.businessservices.ResponseBusinessServices;
import org.agendifive.establishments.service.businessservices.BusinessServicesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/businessservices")
public class BusinessServicesController {

    @Autowired
    private BusinessServicesInterface businessServicesInterface;
    @GetMapping("/getservices/")
    @Operation(
            summary = "Obtiene servicios",
            description = "Retorna una lista de servicios activos"
    )
    public ResponseBusinessServices getschedulebyspecialistbydate() {
        return businessServicesInterface.getServices();
    }
}

