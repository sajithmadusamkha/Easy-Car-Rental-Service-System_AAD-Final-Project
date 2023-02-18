package lk.ijse.easyCarRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class DriverDTO {
    private String driverId;
    private String name;
    private String licenseNo;
    private String contactNo;
    private String availability;
}
