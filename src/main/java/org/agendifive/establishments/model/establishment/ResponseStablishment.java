package org.agendifive.establishments.model.establishment;

import org.agendifive.establishments.model.establishment.Establishment;

import java.util.List;

public class ResponseStablishment {
    private boolean success;
    private String message;
    private List<Establishment> data;

    // Constructor completo
    public ResponseStablishment(boolean success, String message, List<Establishment> data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }


    public ResponseStablishment() {
    }

    // Getters y Setters
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Establishment> getData() {
        return data;
    }

    public void setData(List<Establishment> data) {
        this.data = data;
    }
}
