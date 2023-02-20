package lk.ijse.easyCarRental.repo;

import lk.ijse.easyCarRental.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin,String> {
}
