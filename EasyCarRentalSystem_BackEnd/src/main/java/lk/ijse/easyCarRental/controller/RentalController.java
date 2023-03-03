package lk.ijse.easyCarRental.controller;

import lk.ijse.easyCarRental.dto.RentalDTO;
import lk.ijse.easyCarRental.service.RentalService;
import lk.ijse.easyCarRental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/rent")
@CrossOrigin
public class RentalController {

    @Autowired
    private RentalService service;

    @PostMapping
    public ResponseUtil saveRental(@RequestBody RentalDTO rentalDTO) {
        service.saveRental(rentalDTO);
        return new ResponseUtil("200", "Successfully Rent.!", null);
    }

    @DeleteMapping(params = "rentalId")
    public ResponseUtil deleteRental(String rentalId){
        service.deleteRental(rentalId);
        return new ResponseUtil("200",rentalId+" : Deleted.!",null);
    }
}
