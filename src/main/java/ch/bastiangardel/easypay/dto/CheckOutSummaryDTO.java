package ch.bastiangardel.easypay.dto;

import ch.bastiangardel.easypay.model.CheckOut;

/**
 * Created by bastiangardel on 22.06.16.
 */
public class CheckOutSummaryDTO {
    private String uuid;
    private String name;

    public void modelToDto(CheckOut checkOut)
    {
        uuid = checkOut.getUuid();
        name = checkOut.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
