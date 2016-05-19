package com.github.pires.example.dto;

/**
 * Created by bastiangardel on 19.05.16.
 */
public class SuccessMessageDTO {

    private String successMessage;

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public SuccessMessageDTO(String successMessage) {
        this.successMessage = successMessage;
    }
}
