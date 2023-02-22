package lk.ijse.easyCarRental.service.impl;

import lk.ijse.easyCarRental.dto.DriverDTO;
import lk.ijse.easyCarRental.entity.Driver;
import lk.ijse.easyCarRental.repo.DriverRepo;
import lk.ijse.easyCarRental.service.DriverService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void addDriver(DriverDTO dto) {
        if (repo.existsById(dto.getDriverId())) {
            throw new RuntimeException("Driver "+dto.getDriverId()+" Already Exist..!");
        }
        repo.save(mapper.map(dto, Driver.class));
    }

    @Override
    public void deleteDriver(String id) {

    }

    @Override
    public void updateDriver(DriverDTO entity) {

    }

    @Override
    public List<DriverDTO> getAllDriver() {
        return null;
    }
}
