package lk.ijse.easyCarRental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
public class Car {
    @Id
    private String carRegNo;
    private String brand;
    private String type;
    private String transmissionType;
    private String fuelType;
    private String color;
    private int noOfPassenger;
    private String fontImage;
    private String backImage;
    private String sideImage;
    private String interiorImage;
    private double dailyRate;
    private double monthlyRate;
    private long freeKmForDaily;
    private long freeKmForMonth;
    private double pricePerExtraKm;
    private String availability;
}
