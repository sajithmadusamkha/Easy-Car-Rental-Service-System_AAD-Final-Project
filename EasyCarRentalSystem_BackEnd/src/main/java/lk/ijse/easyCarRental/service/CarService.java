package lk.ijse.easyCarRental.service;

import lk.ijse.easyCarRental.dto.CarDTO;

import java.util.List;

public interface CarService {
    public void saveCar(CarDTO dto);

    public void deleteCar(String carRegNo);

    public void updateCar(CarDTO dto);

    public List<CarDTO> getAllCars();

    public CarDTO searchCar(String carRegNo);
}
