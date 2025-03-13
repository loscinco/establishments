package org.agendifive.establishments.model.businessservices;

import java.util.List;

public class ResponseBusinessServices {

    private boolean success;
    private String message;
    private List<Services> data;

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

    public List<Services> getData() {
        return data;
    }

    public void setData(List<Services> data) {
        this.data = data;
    }
}
