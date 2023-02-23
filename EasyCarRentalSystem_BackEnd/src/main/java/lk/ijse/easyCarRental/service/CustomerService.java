package lk.ijse.easyCarRental.service;

import lk.ijse.easyCarRental.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void addCustomer(CustomerDTO dto);

    void deleteCustomer(String customerId);

    void updateCustomer(CustomerDTO dto);

    List<CustomerDTO> getAllCustomer();
}
