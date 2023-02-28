package lk.ijse.easyCarRental.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class RentalDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentalDetailId;
    private LocalDate pickupDate;
    private LocalDate returnDate;
    private String rentalStatus;
    private String bankSlip;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "rentalId", referencedColumnName = "rentalId")
    private Rental rentalId;

    public RentalDetails(LocalDate pickupDate,LocalDate returnDate,String rentalStatus,String bankSlip) {
        this.pickupDate = pickupDate;
        this.returnDate = returnDate;
        this.rentalStatus = rentalStatus;
        this.bankSlip = bankSlip;
    }
}
