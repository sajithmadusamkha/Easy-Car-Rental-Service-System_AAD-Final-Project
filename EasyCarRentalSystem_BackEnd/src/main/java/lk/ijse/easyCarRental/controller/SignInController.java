package lk.ijse.easyCarRental.controller;

import lk.ijse.easyCarRental.dto.AdminDTO;
import lk.ijse.easyCarRental.dto.CustomerDTO;
import lk.ijse.easyCarRental.dto.DriverDTO;
import lk.ijse.easyCarRental.dto.UserDTO;
import lk.ijse.easyCarRental.service.AdminService;
import lk.ijse.easyCarRental.service.CustomerService;
import lk.ijse.easyCarRental.service.DriverService;
import lk.ijse.easyCarRental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/signIn")
@CrossOrigin
public class SignInController {

    @Autowired
    CustomerService customerService;

    @Autowired
    DriverService driverService;

    @Autowired
    AdminService adminService;

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil login(@RequestBody UserDTO userDTO) {
        adminService.saveAdmin();

        CustomerDTO customerDTO = customerService.getCustomerForLogin(userDTO);

        if (customerDTO == null){
            DriverDTO driver = driverService.getDriverForLogin(userDTO);
            if (driver == null) {
                AdminDTO admin = adminService.getAdminForLogin(userDTO);
                if (!(admin == null)){
                    return new ResponseUtil("200" , "Admin", admin);
                } else {
                    return new ResponseUtil("200","Incorrect user name and password",null);
                }
            } else {
                return new ResponseUtil("200" , "Driver", driver);
            }
        } else {
            return new ResponseUtil("200" , "Customer", customerDTO);
        }
    }
}
