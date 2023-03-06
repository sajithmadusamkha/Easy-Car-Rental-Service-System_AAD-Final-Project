package lk.ijse.easyCarRental.controller;

import lk.ijse.easyCarRental.dto.PaymentDTO;
import lk.ijse.easyCarRental.service.PaymentService;
import lk.ijse.easyCarRental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/payment")
@CrossOrigin
public class PaymentController {

    @Autowired
    PaymentService service;

    @PostMapping
    public ResponseUtil savePayment(@RequestBody PaymentDTO dto) {
        service.savePayment(dto);
        return new ResponseUtil("200",dto.getPaymentId()+ " Paid...!",null);
    }

}
