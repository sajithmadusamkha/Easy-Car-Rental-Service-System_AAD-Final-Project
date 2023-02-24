package lk.ijse.easyCarRental.service.impl;

import lk.ijse.easyCarRental.dto.CarDTO;
import lk.ijse.easyCarRental.entity.Car;
import lk.ijse.easyCarRental.repo.CarRepo;
import lk.ijse.easyCarRental.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveCar(CarDTO dto) {
        if(!repo.existsById(dto.getCarRegNo())) {
            Car car = mapper.map(dto, Car.class);
            repo.save(car);
        }else {
            throw new RuntimeException("This Car Registration Number Already Exist..!");
        }
    }

    @Override
    public void deleteCar(String carRegNo) {
        if(!repo.existsById(carRegNo)){
            throw new RuntimeException("Customer " + carRegNo + " not available to delete");
        }
        repo.deleteById(carRegNo);
    }

    @Override
    public void updateCar(CarDTO dto) {
        if(!repo.existsById(dto.getCarRegNo())) {
            Car car = mapper.map(dto, Car.class);
            repo.save(car);
        }else {
            throw new RuntimeException("Car " + dto.getCarRegNo() + " not available to update");
        }
    }

    @Override
    public List<CarDTO> getAllCars() {
        return mapper.map(repo.findAll(), new TypeToken<ArrayList<CarDTO>>(){}.getType());
    }

    @Override
    public CarDTO searchCar(String carRegNo) {
        Car car = repo.findById(carRegNo).get();
        CarDTO carDTO = mapper.map(car, CarDTO.class);
        return carDTO;
    }
}
