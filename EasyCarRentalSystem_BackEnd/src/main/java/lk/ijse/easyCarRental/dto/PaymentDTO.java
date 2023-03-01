package lk.ijse.easyCarRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class PaymentDTO {
    private String paymentId;
    private LocalDate date;
    private double amount;
    private double damageCost;
    private String damageDescription;
    private long extraMileage;
    private double costPerExtraKm;
    private String paymentStratus;
    private String rentalId;
}
