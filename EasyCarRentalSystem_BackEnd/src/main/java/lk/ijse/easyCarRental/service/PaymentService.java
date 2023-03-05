package lk.ijse.easyCarRental.service;

import lk.ijse.easyCarRental.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {
    public void savePayment(PaymentDTO dto);

    public void deletePayment(String paymentId);

    public void updatePayment(PaymentDTO dto);

    public PaymentDTO searchPayment(String paymentId);

    public List<PaymentDTO> getAllPayment();
}
