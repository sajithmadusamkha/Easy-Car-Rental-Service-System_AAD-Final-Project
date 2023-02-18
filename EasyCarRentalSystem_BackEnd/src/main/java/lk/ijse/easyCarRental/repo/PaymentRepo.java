package lk.ijse.easyCarRental.repo;

import lk.ijse.easyCarRental.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment,String> {
}
