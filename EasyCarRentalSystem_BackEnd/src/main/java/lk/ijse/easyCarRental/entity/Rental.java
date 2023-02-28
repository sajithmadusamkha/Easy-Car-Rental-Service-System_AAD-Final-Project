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

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "customerId", referencedColumnName = "customerId", nullable = false)
    private Customer cusId;
    private LocalDate date;

    @OneToMany(mappedBy = "rentalId")
    @JsonIgnore
    private List<RentalDetails> rentalDetails;

    public Rental(String rentalId, Customer cusId, LocalDate date) {
        this.rentalId = rentalId;
        this.cusId = cusId;
        this.date = date;
    }
}
