package lk.ijse.easyCarRental.controller;

import lk.ijse.easyCarRental.dto.CustomerDTO;
import lk.ijse.easyCarRental.service.CustomerService;
import lk.ijse.easyCarRental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /*@ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path="register",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil customerRegister(@RequestPart("files") MultipartFile[] file, @RequestPart("customer") CustomerDTO dto) {
        for (MultipartFile myFile : file) {
            try {
                String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
                File uploadsDir = new File(projectPath + "/uploads");
                uploadsDir.mkdir();
                myFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + myFile.getOriginalFilename()));
                System.out.println(projectPath);
            }  catch (IOException | URISyntaxException e) {
                e.printStackTrace();
                return new ResponseUtil("500", "Registration Failed.Try Again Latter", null);
            }
        }

        dto.setDrivingLicenseImage("uploads/" + dto.getDrivingLicenseImage());
        dto.setNicImage("uploads/" + dto.getNicImage());
        customerService.addCustomer(dto);
        return new ResponseUtil("200", "Registration Successful" , dto);
    }*/

    @PostMapping
    public ResponseUtil saveCustomer(@RequestBody CustomerDTO dto){
        customerService.addCustomer(dto);
        return new ResponseUtil("200",dto.getCustomerId()+ " Added...!",null);
    }

    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO dto){
        customerService.updateCustomer(dto);
        return new ResponseUtil("200",dto.getCustomerId()+": Updated.!",null);
    }

    @DeleteMapping(params = "customerId")
    public ResponseUtil deleteCustomer(String customerId){
        customerService.deleteCustomer(customerId);
        return new ResponseUtil("200",customerId+" : Deleted.!",null);
    }

    @GetMapping
    public ResponseUtil getAllCustomer(){
        List<CustomerDTO> allCustomers = customerService.getAllCustomer();
        return new ResponseUtil("200"," Success.!",allCustomers);
    }
}
