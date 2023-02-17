package lk.ijse.easyCarRental.repo;

import lk.ijse.easyCarRental.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,String> {
}
