package lk.ijse.easyCarRental.repo;

import lk.ijse.easyCarRental.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CarRepo extends JpaRepository<Car,String> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE Car SET fontImage=:fontImage,backImage=:backImage,sideImage=:sideImage,interiorImage=:interiorImage WHERE carRegNo=:carRegNo", nativeQuery = true)
    public void updateCarFilePath(@Param("fontImage") String fontImage,@Param("backImage") String backImage,@Param("sideImage") String sideImage,@Param("interiorImage") String interiorImage,@Param("carRegNo") String carRegNo);
}
