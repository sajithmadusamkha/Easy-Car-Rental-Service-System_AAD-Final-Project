package lk.ijse.easyCarRental.service.impl;

import lk.ijse.easyCarRental.dto.CustomerDTO;
import lk.ijse.easyCarRental.entity.Customer;
import lk.ijse.easyCarRental.repo.CustomerRepo;
import lk.ijse.easyCarRental.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void addCustomer(CustomerDTO dto) {
        if(repo.existsById(dto.getCustomerId())){
            throw new RuntimeException("Customer " + dto.getCustomerId() + " already Exist!");
        }
        repo.save(mapper.map(dto, Customer.class));
    }

    @Override
    public void deleteCustomer(String id) {

    }

    @Override
    public void updateCustomer(CustomerDTO dto) {

    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return null;
    }
}
