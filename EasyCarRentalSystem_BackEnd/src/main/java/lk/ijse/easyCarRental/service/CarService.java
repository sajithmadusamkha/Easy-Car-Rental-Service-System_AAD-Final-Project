package lk.ijse.easyCarRental.service;

import lk.ijse.easyCarRental.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarService extends JpaRepository<Car, String> {
}
