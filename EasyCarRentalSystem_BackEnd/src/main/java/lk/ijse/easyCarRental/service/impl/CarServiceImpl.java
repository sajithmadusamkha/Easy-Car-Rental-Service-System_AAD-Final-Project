package lk.ijse.easyCarRental.service.impl;

import lk.ijse.easyCarRental.dto.CarDTO;
import lk.ijse.easyCarRental.entity.Car;
import lk.ijse.easyCarRental.repo.CarRepo;
import lk.ijse.easyCarRental.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService {

    @Autowired
    CarRepo carRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveCar(CarDTO dto) {
        if(!carRepo.existsById(dto.getCarRegNo())) {
            Car car = mapper.map(dto, Car.class);
            carRepo.save(car);
        }else {
            throw new RuntimeException("This Car Registration Number is Already Exist..!");
        }
    }

    @Override
    public void deleteCar(String carRegNo) {
        if(!carRepo.existsById(carRegNo)){
            throw new RuntimeException("Car "+carRegNo+" Not Available to Delete..!");
        }
        carRepo.deleteById(carRegNo);
    }

    @Override
    public void updateCar(CarDTO dto) {
        if(!carRepo.existsById(dto.getCarRegNo())) {
            Car car = mapper.map(dto, Car.class);
            carRepo.save(car);
        }else {
            throw new RuntimeException("Car "+dto.getCarRegNo()+" Not Available to Update..!");
        }
    }

    @Override
    public CarDTO searchVehicle(String carRegNo) {
        Car car = carRepo.findById(carRegNo).get();
        CarDTO carDTO = mapper.map(car, CarDTO.class);
        return carDTO;
    }

    @Override
    public List<CarDTO> getAllVehicle() {
        return mapper.map(carRepo.findAll(),new TypeToken<ArrayList<CarDTO>>(){}.getType());
    }
}
