package org.agendifive.establishments.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class EstablishmentRequest {

    @NotBlank(message = "El nombre del establecimiento es obligatorio.")
    private String name;

    @NotBlank(message = "El NIT o RUT es obligatorio.")
    private String nitRut;

    @NotBlank(message = "La dirección del establecimiento es obligatoria.")
    private String address;

    @NotBlank(message = "La ciudad es obligatoria.")
    private String city;

    @NotNull(message = "El teléfono es obligatorio.")
    @Pattern(regexp = "^\\+?[0-9]{7,15}$", message = "El teléfono debe ser un número válido.")
    private String phone;

    @NotBlank(message = "El correo electrónico es obligatorio.")
    private String email;

    @NotBlank(message = "El estado es obligatorio.")
    @Pattern(regexp = "^[AI]$", message = "El estado debe ser 'A' para activo o 'I' para inactivo.")
    private String status;

    @NotNull(message = "El horario de atención es obligatorio.")
    private EstablishmentScheduleRequest schedules; // Horarios de atención

    private int establishmentType;

    private int subscriptionType;

    // Getters y Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNitRut() {
        return nitRut;
    }

    public void setNitRut(String nitRut) {
        this.nitRut = nitRut;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public EstablishmentScheduleRequest getSchedules() {
        return schedules;
    }

    public void setSchedules(EstablishmentScheduleRequest schedules) {
        this.schedules = schedules;
    }

    public int getEstablishmentType() {
        return establishmentType;
    }

    public void setEstablishmentType(int establishmentType) {
        this.establishmentType = establishmentType;
    }

    public int getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(int subscriptionType) {
        this.subscriptionType = subscriptionType;
    }
}