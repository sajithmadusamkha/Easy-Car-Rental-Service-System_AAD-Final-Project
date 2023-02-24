package lk.ijse.easyCarRental.controller;

import lk.ijse.easyCarRental.dto.CarDTO;
import lk.ijse.easyCarRental.service.CarService;
import lk.ijse.easyCarRental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/car")
@CrossOrigin
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping
    public ResponseUtil saveCar(@RequestBody CarDTO dto){
        carService.saveCar(dto);
        return new ResponseUtil("200",dto.getCarRegNo()+ " Added...!",null);
    }

    @PutMapping
    public ResponseUtil updateCar(@RequestBody CarDTO dto){
        carService.updateCar(dto);
        return new ResponseUtil("200",dto.getCarRegNo()+": Updated.!",null);
    }

    @DeleteMapping(params = {"carRegNo"})
    public ResponseUtil deleteCar(@RequestParam String carRegNo){
        carService.deleteCar(carRegNo);
        return new ResponseUtil("200",carRegNo+" : Deleted.!",null);
    }

    @GetMapping(params = {"carRegNo"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getCar(@RequestParam String carRegNo){
        CarDTO dto = carService.searchCar(carRegNo);
        return new ResponseUtil("200","OK",dto);
    }

    @GetMapping
    public ResponseUtil getAllCars(){
        List<CarDTO> cars = carService.getAllCars();
        return new ResponseUtil("200"," Success.!",cars);
    }
}
