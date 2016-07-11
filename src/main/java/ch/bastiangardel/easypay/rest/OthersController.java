package ch.bastiangardel.easypay.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.http.HTTPBinding;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by bastiangardel on 08.07.16.
 */
@RestController
@RequestMapping(value = "/error")
public class OthersController {

    @RequestMapping(method = GET)
    public String errorGET() {
        return "Error handling";
    }

}
