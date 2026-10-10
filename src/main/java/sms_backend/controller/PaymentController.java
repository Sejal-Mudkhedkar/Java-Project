package sms_backend.controller;

import org.springframework.web.bind.annotation.*;
import sms_backend.dao.PaymentDAO;
import sms_backend.model.Payment;

import java.util.List;

@RestController
@RequestMapping("/payments")
@CrossOrigin(origins = "http://localhost:3000")
public class PaymentController {

    private final PaymentDAO paymentDAO;

    public PaymentController() {
        this.paymentDAO = new PaymentDAO();
    }

    // GET ALL PAYMENTS
    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentDAO.getAllPayments();
    }

    // GET PAYMENT BY ID
    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable Integer id) {
        return paymentDAO.getPaymentById(id);
    }

    // CREATE PAYMENT
    @PostMapping
    public int addPayment(@RequestBody Payment payment) {
        return paymentDAO.addPayment(payment);
    }

    // UPDATE PAYMENT
    @PutMapping("/{id}")
    public boolean updatePayment(
            @PathVariable Integer id,
            @RequestBody Payment payment) {
        payment.setPaymentID(id);
        return paymentDAO.updatePayment(payment);
    }

    // DELETE PAYMENT
    @DeleteMapping("/{id}")
    public boolean deletePayment(@PathVariable Integer id) {
        return paymentDAO.deletePayment(id);
    }
}