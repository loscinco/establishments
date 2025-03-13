package org.agendifive.establishments.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.agendifive.establishments.service.establishment.EstablishmentInterface;
import org.agendifive.establishments.model.establishment.EstablishmentRequest;
import org.agendifive.establishments.model.establishment.ResponseStablishment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/establishments")
@Tag(name = "EstablishmentsController", description = "Controlador para obtenenr informacion de los Establecimientos")
public class EstablishmentController {

    @Autowired
    private EstablishmentInterface establishmenti;

    @PostMapping("/save")
    @Operation(summary = "Create un nuevo establecimiento", description = "este endpoint crea un nuevo establecimiento y devuelve el id ")
    public ResponseStablishment createEstablishment(
            @Valid @RequestBody @Parameter(description = "descripcion del nuevo establecimiento") EstablishmentRequest establishmentRequest) {
        return establishmenti.saveEstablishment(establishmentRequest);
    }

    @GetMapping("/active")
    @Operation(summary = "Obtener establecimientos activos", description = "Este endpoint devuelve una lista de establecimientos con estado 'A'.")
    public ResponseStablishment getActiveEstablishments() {
        return establishmenti.getActiveEstablishments();
    }

}