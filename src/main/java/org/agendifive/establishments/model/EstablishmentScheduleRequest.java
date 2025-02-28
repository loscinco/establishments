package org.agendifive.establishments.model;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EstablishmentScheduleRequest {

    @NotBlank(message = "Los días de la semana son obligatorios.")
    private String daysOfWeek;

    @NotNull(message = "La hora de inicio es obligatoria.")
    @Schema(description = "Hora de inicio en formato HH:mm:ss", example = "10:00:00")
    private String startTime;

    @NotNull(message = "La hora de fin es obligatoria.")
    @Schema(description = "Hora de fin en formato HH:mm:ss", example = "20:00:00")
    private String endTime;



    public String getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(String daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String time) {
        this.startTime = time;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}