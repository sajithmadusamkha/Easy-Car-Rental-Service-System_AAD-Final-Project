package lk.ijse.easyCarRental.controller;

import lk.ijse.easyCarRental.dto.DriverDTO;
import lk.ijse.easyCarRental.service.DriverService;
import lk.ijse.easyCarRental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/driver")
@CrossOrigin
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping
    public ResponseUtil saveCustomer(@ModelAttribute DriverDTO dto){
        driverService.addDriver(dto);
        return new ResponseUtil("200",dto.getDriverId()+ " Added.!",null);
    }
}
