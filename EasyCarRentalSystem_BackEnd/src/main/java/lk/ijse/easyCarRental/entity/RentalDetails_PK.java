package lk.ijse.easyCarRental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Embeddable
public class RentalDetails_PK implements Serializable {
    private String rentalId;
    private String carNo;
}
