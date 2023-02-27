package lk.ijse.easyCarRental.service.impl;

import lk.ijse.easyCarRental.dto.AdminDTO;
import lk.ijse.easyCarRental.dto.UserDTO;
import lk.ijse.easyCarRental.entity.Admin;
import lk.ijse.easyCarRental.repo.AdminRepo;
import lk.ijse.easyCarRental.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminRepo adminRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveAdmin() {
        Admin admin = new Admin("A-001","sajith@gmail.com","admin","admin");
        adminRepo.save(admin);
    }

    @Override
    public AdminDTO getAdminForLogin(UserDTO userDTO) {
        List<Admin> allAdmins = adminRepo.findAll();
        for(Admin a : allAdmins) {
            if (a.getEmail().equals(userDTO.getEmail()) & a.getPassword().equals(userDTO.getPassword())){

            }
        }
        return null;
    }

    @Override
    public AdminDTO searchAdmin(String adminId) {
        return null;
    }
}
