package lk.ijse.easyCarRental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Customer {
    @Id
    private String customerId;
    private String name;
    private String email;
    private String password;
    private String contactNo;
    private String address;
    private String nicNo;
    private String drivingLicenseNo;
    private String nicImage;
    private String drivingLicenseImage;

    @OneToMany(mappedBy = "customerId")
    private List<Rental> rentalDetails;
}
