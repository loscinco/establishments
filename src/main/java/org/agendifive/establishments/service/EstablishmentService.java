package org.agendifive.establishments.service;

import org.agendifive.establishments.model.Establishment;
import org.agendifive.establishments.model.EstablishmentRequest;
import org.agendifive.establishments.model.EstablishmentSchedule;
import org.agendifive.establishments.model.ResponseStablishment;
import org.agendifive.establishments.service.EstablishmentInterface;
import org.agendifive.establishments.service.EstablishmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class EstablishmentService implements EstablishmentInterface {
    @Autowired
    private EstablishmentRepository establishmentRepository;

    public ResponseStablishment saveEstablishment(EstablishmentRequest request) {
        ResponseStablishment response = new ResponseStablishment();
        //  Validar los datos del request
        if (request.getName() == null || request.getName().isEmpty()) {
            response.setSuccess(false);
            response.setMessage("El nombre del establecimiento es obligatorio.");
            return response;
        }
        if (request.getNitRut() == null || request.getNitRut().isEmpty()) {
            response.setSuccess(false);
            response.setMessage("El NIT o RUT del establecimiento es obligatorio.");
            return response;
        }
        if (request.getStatus() == null || (!request.getStatus().equals("A") && !request.getStatus().equals("I"))) {
            response.setSuccess(false);
            response.setMessage("El estado debe ser 'A' o 'I'.");
            return response;
        }
        if (request.getEmail() == null || !request.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            response.setSuccess(false);
            response.setMessage("No es posible crear el establecimiento porque el correo no es válido.");
            return response;
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            Establishment establishment = new Establishment();
            EstablishmentSchedule establishmentSchedule = new EstablishmentSchedule();


            LocalTime start = LocalTime.parse(request.getSchedules().getStartTime(), formatter);
            LocalTime end = LocalTime.parse(request.getSchedules().getEndTime(), formatter);


            establishment.setName(request.getName());
            establishment.setNitRut(request.getNitRut());
            establishment.setAddress(request.getAddress());
            establishment.setPhone(request.getPhone());
            establishment.setEmail(request.getEmail());
            establishment.setStatus(request.getStatus());
            establishment.setSubscriptionType(request.getSubscriptionType());
            establishment.setEstablishmentTypeId(request.getEstablishmentType());


            establishmentSchedule.setDaysOfWeek(request.getSchedules().getDaysOfWeek());
            establishmentSchedule.setStartTime(start);
            establishmentSchedule.setEndTime(end);


            establishmentSchedule.setEstablishment(establishment);
            establishment.setSchedule(establishmentSchedule);


            establishmentRepository.save(establishment);


            response.setSuccess(true);
            response.setMessage("Establecimiento guardado correctamente.");


        } catch (Exception e) {

            response.setSuccess(false);
            response.setMessage("Error al guardar el establecimiento: " + e.getMessage());
        }

        return response;
    }

    @Override
    public ResponseStablishment getActiveEstablishments() {
        ResponseStablishment responseStablishment = new ResponseStablishment(false,"no es posible obtnerne establecimientos",null);
        try {
           List<Establishment> establishmentList = establishmentRepository.findByStatus("A");
           if(establishmentList.size()>0){
               responseStablishment.setSuccess(true);
               responseStablishment.setMessage("estableciminetos obtenidos correctamente");
               responseStablishment.setData(establishmentList);
           }
        }catch (Exception e){

        }
        return responseStablishment;

    }
}
