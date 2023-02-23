package lk.ijse.easyCarRental.service;

import lk.ijse.easyCarRental.dto.DriverDTO;

import java.util.List;

public interface DriverService {
    void addDriver(DriverDTO dto);

    void deleteDriver(String driverId);

    void updateDriver(DriverDTO entity);

    List<DriverDTO> getAllDriver();
}
