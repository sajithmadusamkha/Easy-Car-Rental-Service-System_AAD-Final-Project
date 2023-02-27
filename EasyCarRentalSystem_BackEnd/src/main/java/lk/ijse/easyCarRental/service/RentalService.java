package lk.ijse.easyCarRental.service;

import lk.ijse.easyCarRental.dto.RentalDTO;

import java.util.List;

public interface RentalService {
    public void saveRental(RentalDTO rental);

    public void deleteRental(String rentalId);

    public void updateRental(RentalDTO rentalDTO);

    public List<RentalDTO> getAllRentals();
}
