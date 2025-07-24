package com.green.form.controller;

import com.green.form.dto.DeliveryDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryController {
  @PostMapping("/deliverys")
  public DeliveryDTO insertDelivery(@RequestBody DeliveryDTO deliveryDTO){
    System.out.println(deliveryDTO);
    return deliveryDTO;
  }
}
