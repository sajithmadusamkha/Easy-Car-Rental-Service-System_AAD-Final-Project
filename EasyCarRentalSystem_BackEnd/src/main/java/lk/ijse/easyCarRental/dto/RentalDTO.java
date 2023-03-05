package lk.ijse.easyCarRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RentalDTO {
    private String rentalId;
    private String customerId;
    private LocalDate date;
    private LocalDate pickupDate;
    private LocalDate returnDate;
    private double amount;
    private double ldwPayment;
    private String pickUpLocation;
    private String driverStatus;
    private String carRegNo;

    private ArrayList<RentalDetailsDTO> rentalDetails;
}
