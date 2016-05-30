package ch.bastiangardel.easypay.dto;

import ch.bastiangardel.easypay.model.User;
import ch.bastiangardel.easypay.model.CheckOut;

import java.util.Date;

/**
 * Created by bastiangardel on 17.05.16.
 */
public class CheckOutCreationDTO {

    private String uuid;
    private String name;
    private String email;

    public CheckOut dtoToModel(User user)
    {
        CheckOut tmp = new CheckOut();
        tmp.setUuid(uuid);
        tmp.setName(name);
        tmp.setOwner(user);
        tmp.setCreated(new Date());
        return tmp;
    }


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
