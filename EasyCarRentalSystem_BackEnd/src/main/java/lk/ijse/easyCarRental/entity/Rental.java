package lk.ijse.easyCarRental.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
public class Rental {
    @Id
    private String rentalId;
    @ManyToOne
    private Customer customerId;
    private LocalDate date;
    private LocalDate pickupDate;
    private LocalDate returnDate;
    private double amount;
    private double ldwPayment;
    private String pickUpLocation;
    private String driverStatus;
}
