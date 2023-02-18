package lk.ijse.easyCarRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class AdminDTO {
    private String adminId;
    private String email;
    private String userName;
    private String password;
}
