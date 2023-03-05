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
    @EmbeddedId
    private RentalDetails_PK id;
    @ManyToOne
    private Driver driverId;
    private String bankSlip;

    @ManyToOne
    private Rental rental;
}
