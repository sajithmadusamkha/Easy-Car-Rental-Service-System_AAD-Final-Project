package lk.ijse.easyCarRental.service;

import lk.ijse.easyCarRental.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    public void addCustomer(CustomerDTO dto);

    public void deleteCustomer(String id);

    public void updateCustomer(CustomerDTO dto);

    public List<CustomerDTO> getAllCustomer();
}
