package lk.ijse.easyCarRental.service.impl;

import lk.ijse.easyCarRental.dto.AdminDTO;
import lk.ijse.easyCarRental.dto.CustomerDTO;
import lk.ijse.easyCarRental.dto.UserDTO;
import lk.ijse.easyCarRental.entity.Admin;
import lk.ijse.easyCarRental.entity.Customer;
import lk.ijse.easyCarRental.repo.CustomerRepo;
import lk.ijse.easyCarRental.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public void deleteCustomer(String customerId) {
        if(!repo.existsById(customerId)){
            throw new RuntimeException("Customer " + customerId + " not available to delete");
        }
        repo.deleteById(customerId);
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        if(!repo.existsById(dto.getCustomerId())){
            throw new RuntimeException("Customer " + dto.getCustomerId() + " not available to update");
        }
        repo.save(mapper.map(dto, Customer.class));
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return mapper.map(repo.findAll(), new TypeToken<ArrayList<CustomerDTO>>(){}.getType());
    }

    @Override
    public CustomerDTO getCustomerForLogin(UserDTO userDTO) {
        List<Customer> allCus = repo.findAll();
        for(Customer c : allCus) {
            if (c.getEmail().equals(userDTO.getEmail()) & c.getPassword().equals(userDTO.getPassword())){
                return new CustomerDTO(c.getCustomerId(),c.getName(),c.getEmail(), c.getPassword(), c.getContactNo(),
                        c.getAddress(),c.getNicNo(),c.getDrivingLicenseNo(),c.getNicImage(),c.getDrivingLicenseImage());
            }
        }
        return null;
    }
}
