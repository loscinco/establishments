package org.agendifive.establishments;
import org.agendifive.establishments.model.establishment.Establishment;
import org.agendifive.establishments.model.establishment.EstablishmentRequest;
import org.agendifive.establishments.model.establishment.EstablishmentScheduleRequest;
import org.agendifive.establishments.model.establishment.ResponseStablishment;
import org.agendifive.establishments.service.establishment.EstablishmentRepository;
import org.agendifive.establishments.service.establishment.EstablishmentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EstablishmentServiceTest {

    @Mock
    private EstablishmentRepository establishmentRepository;

    @InjectMocks
    private EstablishmentService establishmentService;

    @Test
    void saveEstablishment_SuccessfulSave() {

        EstablishmentRequest request = new EstablishmentRequest();
        request.setName("Test Establecimiento");
        request.setNitRut("123456789");
        request.setAddress("Calle 123");
        request.setPhone("3001234567");
        request.setEmail("test@correo.com");
        request.setEstablishmentType(1);
        request.setEstablishmentType(2);
        request.setStatus("A");

        EstablishmentScheduleRequest scheduleRequest = new EstablishmentScheduleRequest();
        scheduleRequest.setDaysOfWeek("Lunes-Viernes");
        scheduleRequest.setStartTime("10:00:00");
        scheduleRequest.setEndTime("18:00:00");
        request.setSchedules(scheduleRequest);

        Establishment establishment = new Establishment();
        establishment.setName(request.getName());
        establishment.setNitRut(request.getNitRut());
        establishment.setAddress(request.getAddress());
        establishment.setPhone(request.getPhone());
        establishment.setEmail(request.getEmail());
        establishment.setStatus(request.getStatus());

        // Simulamos el repositorio
        when(establishmentRepository.save(any(Establishment.class))).thenReturn(establishment);

        ResponseStablishment response = establishmentService.saveEstablishment(request);

        assertTrue(response.isSuccess(), "El establecimiento debería guardarse correctamente");
        assertEquals("Establecimiento guardado correctamente.", response.getMessage());

        // Verificar que se llamó una vez a save()
        verify(establishmentRepository, times(1)).save(any(Establishment.class));
    }

    @Test
    void saveEstablishment_InvalidEmail_ShouldFail() {

        EstablishmentRequest request = new EstablishmentRequest();
        request.setName("Test Establecimiento");
        request.setNitRut("123456789");
        request.setAddress("Calle 123");
        request.setPhone("3001234567");
        request.setEmail("correo-invalido"); // Correo incorrecto
        request.setStatus("A");

        EstablishmentScheduleRequest scheduleRequest = new EstablishmentScheduleRequest();
        scheduleRequest.setDaysOfWeek("Lunes-Viernes");
        scheduleRequest.setStartTime("08:00:00");
        scheduleRequest.setEndTime("18:00:00");

        request.setSchedules(scheduleRequest);


        ResponseStablishment response = establishmentService.saveEstablishment(request);


        assertFalse(response.isSuccess());
        assertEquals("No es posible crear el establecimiento porque el correo no es válido.", response.getMessage());
        verify(establishmentRepository, never()).save(any(Establishment.class));
    }
}