package lk.ijse.easyCarRental.service.impl;

import lk.ijse.easyCarRental.dto.PaymentDTO;
import lk.ijse.easyCarRental.entity.Payment;
import lk.ijse.easyCarRental.repo.PaymentRepo;
import lk.ijse.easyCarRental.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepo paymentRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void savePayment(PaymentDTO dto) {
        if (paymentRepo.existsById(dto.getPaymentId())){
            throw new RuntimeException("This Payment is"+dto.getPaymentId()+" Already Added..!");
        }
        paymentRepo.save(mapper.map(dto, Payment.class));
    }

    @Override
    public void deletePayment(String paymentId) {
        if (!paymentRepo.existsById(paymentId)){
            throw new RuntimeException("This Payment "+paymentId+" is not available to delete..!");
        }

        paymentRepo.deleteById(paymentId);
    }

    @Override
    public void updatePayment(PaymentDTO dto) {

    }

    @Override
    public PaymentDTO searchPayment(String paymentId) {
        Payment payment = paymentRepo.findById(paymentId).get();
        PaymentDTO paymentDTO = mapper.map(payment, PaymentDTO.class);
        return paymentDTO;
    }

    @Override
    public List<PaymentDTO> getAllPayment() {
        return null;
    }
}
