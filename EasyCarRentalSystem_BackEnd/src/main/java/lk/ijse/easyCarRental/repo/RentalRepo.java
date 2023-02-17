package lk.ijse.easyCarRental.repo;

import lk.ijse.easyCarRental.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepo extends JpaRepository<Rental,String> {
}
