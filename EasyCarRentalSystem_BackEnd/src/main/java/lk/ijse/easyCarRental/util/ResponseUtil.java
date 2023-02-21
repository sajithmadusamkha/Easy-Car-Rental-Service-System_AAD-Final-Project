package lk.ijse.easyCarRental.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class ResponseUtil {
    private String code;
    private String massage;
    private Object data;
}
