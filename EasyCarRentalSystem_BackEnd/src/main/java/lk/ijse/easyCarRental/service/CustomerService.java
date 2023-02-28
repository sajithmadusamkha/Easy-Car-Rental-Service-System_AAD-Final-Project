package lk.ijse.easyCarRental.service;

import lk.ijse.easyCarRental.dto.CustomerDTO;
import lk.ijse.easyCarRental.dto.UserDTO;

import java.util.List;

public interface CustomerService {
    void addCustomer(CustomerDTO dto);

    void deleteCustomer(String customerId);

    void updateCustomer(CustomerDTO dto);

    List<CustomerDTO> getAllCustomer();

    public CustomerDTO getCustomerForLogin(UserDTO userDTO);
}
