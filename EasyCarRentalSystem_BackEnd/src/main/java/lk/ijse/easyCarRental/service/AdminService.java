package lk.ijse.easyCarRental.service;

import lk.ijse.easyCarRental.dto.AdminDTO;
import lk.ijse.easyCarRental.dto.UserDTO;

public interface AdminService {
    public void saveAdmin();

    public AdminDTO getAdminForLogin(UserDTO userDTO);

    public AdminDTO searchAdmin(String adminId);
}
