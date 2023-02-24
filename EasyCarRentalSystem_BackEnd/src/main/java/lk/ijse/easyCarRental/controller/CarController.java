package lk.ijse.easyCarRental.controller;

import lk.ijse.easyCarRental.dto.CarDTO;
import lk.ijse.easyCarRental.dto.DriverDTO;
import lk.ijse.easyCarRental.service.CarService;
import lk.ijse.easyCarRental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CarController {

    @Autowired
    CarService carService;

    @PostMapping
    public ResponseUtil saveCar(){
        return null;
    }

    @DeleteMapping(params = "carRegNo")
    public ResponseUtil deleteCar(String carRegNo) {
        carService.deleteCar(carRegNo);
        return new ResponseUtil("200",carRegNo + " Deleted...!",null);
    }

    @PutMapping
    public ResponseUtil updateCar(@RequestBody CarDTO dto) {
        carService.updateCar(dto);
        return new ResponseUtil("200",dto.getCarRegNo()+ " Updated...!",null);
    }

    @GetMapping
    public ResponseUtil getAllCars() {
        List<CarDTO> allCars = carService.getAllVehicle();
        return new ResponseUtil("200"," Success.!",allCars);
    }
}
