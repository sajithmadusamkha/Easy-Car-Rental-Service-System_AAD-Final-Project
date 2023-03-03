package lk.ijse.easyCarRental.service.impl;

import lk.ijse.easyCarRental.dto.RentalDTO;
import lk.ijse.easyCarRental.entity.Rental;
import lk.ijse.easyCarRental.repo.RentalRepo;
import lk.ijse.easyCarRental.service.RentalService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RentalServiceImpl implements RentalService {

    @Autowired
    private RentalRepo rentalRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveRental(RentalDTO rentalDTO) {
        Rental rental = mapper.map(rentalDTO, Rental.class);

        if(rentalRepo.existsById(rental.getRentalId())){
            throw new RuntimeException("Rental : " + rental.getRentalId() + " Already Available.!");
        }

        rentalRepo.save(rental);
    }

    @Override
    public void deleteRental(String rentalId) {
        if (!rentalRepo.existsById(rentalId)){
            throw new RuntimeException("Rental:  "+rentalId+" Not Available to Delete..!");
        }
        rentalRepo.deleteById(rentalId);
    }

    @Override
    public void updateRental(RentalDTO rentalDTO) {

    }

    @Override
    public List<RentalDTO> getAllRentals() {
        return mapper.map(rentalRepo.findAll(),new TypeToken<ArrayList<RentalDTO>>(){}.getType());
    }
}
