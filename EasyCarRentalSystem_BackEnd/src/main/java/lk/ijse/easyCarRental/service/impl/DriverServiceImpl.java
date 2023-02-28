package lk.ijse.easyCarRental.service.impl;

import lk.ijse.easyCarRental.dto.CustomerDTO;
import lk.ijse.easyCarRental.dto.DriverDTO;
import lk.ijse.easyCarRental.dto.UserDTO;
import lk.ijse.easyCarRental.entity.Customer;
import lk.ijse.easyCarRental.entity.Driver;
import lk.ijse.easyCarRental.repo.DriverRepo;
import lk.ijse.easyCarRental.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public void deleteDriver(String driverId) {
        if(!repo.existsById(driverId)){
            throw new RuntimeException("Driver "+driverId+" Not Available to Delete..!");
        }
        repo.deleteById(driverId);
    }

    @Override
    public void updateDriver(DriverDTO entity) {
        if (!repo.existsById(entity.getDriverId())){
            throw new RuntimeException("Driver "+entity.getDriverId()+" Not Available to Update..!");
        }
        repo.save(mapper.map(entity, Driver.class));
    }

    @Override
    public List<DriverDTO> getAllDriver() {
        return mapper.map(repo.findAll(),new TypeToken<ArrayList<DriverDTO>>(){}.getType());
    }

    @Override
    public DriverDTO getDriverForLogin(UserDTO userDTO) {
        return null;
    }
}
