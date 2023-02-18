package lk.ijse.easyCarRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class CustomerDTO {
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
}
