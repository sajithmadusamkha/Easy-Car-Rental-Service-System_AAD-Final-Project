package lk.ijse.easyCarRental.dto;

import lk.ijse.easyCarRental.entity.Driver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RentalDetailsDTO {
    private String id;
    private String driverId;
    private String bankSlip;
}
