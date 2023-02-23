package lk.ijse.easyCarRental.controller;

import lk.ijse.easyCarRental.dto.DriverDTO;
import lk.ijse.easyCarRental.service.DriverService;
import lk.ijse.easyCarRental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/driver")
@CrossOrigin
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping
    public ResponseUtil saveDriver(@ModelAttribute DriverDTO dto){
        driverService.addDriver(dto);
        return new ResponseUtil("200",dto.getDriverId()+ " Added...!",null);
    }

    @PutMapping
    public ResponseUtil updateDriver(@RequestBody DriverDTO dto) {
        driverService.updateDriver(dto);
        return new ResponseUtil("200",dto.getDriverId()+ " Updated...!",null);
    }

    @DeleteMapping(params = "driverId")
    public ResponseUtil deleteDriver(String driverId) {
        driverService.deleteDriver(driverId);
        return new ResponseUtil("200",driverId + " Deleted...!",null);
    }

    @GetMapping
    public ResponseUtil getAllDrivers(){
        List<DriverDTO> allDriver = driverService.getAllDriver();
        return new ResponseUtil("200"," Success.!",allDriver);
    }
}
