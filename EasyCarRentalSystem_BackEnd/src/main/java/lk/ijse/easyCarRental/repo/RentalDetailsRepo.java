package lk.ijse.easyCarRental.repo;

import lk.ijse.easyCarRental.entity.RentalDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalDetailsRepo extends JpaRepository<RentalDetails,String> {
}
