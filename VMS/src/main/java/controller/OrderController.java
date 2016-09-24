package controller;

import model.Order;
import model.ProcessOrderResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import utility.MessageUtility;

/**
 * Created by apple on 24/09/16.
 */

@RestController
public class OrderController {

    @RequestMapping(value = "/processOrder", method= RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ProcessOrderResponse getResponse(@RequestBody Order order){
        String messageString = "We are processing your order.Thank you for the cooperation";
        ProcessOrderResponse processOrderResponse = new ProcessOrderResponse();
        processOrderResponse.setDescription(messageString);
        processOrderResponse.setSuccessCode("00");
        processOrderResponse.setSuccessMessage("SUCCESS");
        MessageUtility.sendMessage(order);
        return processOrderResponse;
    }


}
