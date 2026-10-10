package sms_backend.dao;

import sms_backend.model.Payment;
import sms_backend.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {

    // CREATE
    public int addPayment(Payment payment) {

        String sql = """
                INSERT INTO payments
                (BillID, PaymentDate, PaymentMethod,
                 PaymentAmount, TransactionID)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, payment.getBillID());
            ps.setDate(2, payment.getPaymentDate());
            ps.setString(3, payment.getPaymentMethod());
            ps.setDouble(4, payment.getPaymentAmount());
            ps.setString(5, payment.getTransactionID());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    payment.setPaymentID(id);
                    return id;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }


    // READ
    public Payment getPaymentById(int paymentID) {

        String sql =
                "SELECT * FROM payments WHERE PaymentID = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, paymentID);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Payment payment = new Payment();

                    payment.setPaymentID(
                            rs.getInt("PaymentID"));
                    payment.setBillID(
                            rs.getInt("BillID"));
                    payment.setPaymentDate(
                            rs.getDate("PaymentDate"));
                    payment.setPaymentMethod(
                            rs.getString("PaymentMethod"));
                    payment.setPaymentAmount(
                            rs.getDouble("PaymentAmount"));
                    payment.setTransactionID(
                            rs.getString("TransactionID"));

                    return payment;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    // READ ALL
    public List<Payment> getAllPayments() {

        List<Payment> payments = new ArrayList<>();

        String sql = "SELECT * FROM payments";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Payment payment = new Payment();

                payment.setPaymentID(
                        rs.getInt("PaymentID"));
                payment.setBillID(
                        rs.getInt("BillID"));
                payment.setPaymentDate(
                        rs.getDate("PaymentDate"));
                payment.setPaymentMethod(
                        rs.getString("PaymentMethod"));
                payment.setPaymentAmount(
                        rs.getDouble("PaymentAmount"));
                payment.setTransactionID(
                        rs.getString("TransactionID"));

                payments.add(payment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return payments;
    }


    // UPDATE
    public boolean updatePayment(Payment payment) {

        String sql = """
                UPDATE payments
                SET BillID = ?,
                    PaymentDate = ?,
                    PaymentMethod = ?,
                    PaymentAmount = ?,
                    TransactionID = ?
                WHERE PaymentID = ?
                """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, payment.getBillID());
            ps.setDate(2, payment.getPaymentDate());
            ps.setString(3, payment.getPaymentMethod());
            ps.setDouble(4, payment.getPaymentAmount());
            ps.setString(5, payment.getTransactionID());
            ps.setInt(6, payment.getPaymentID());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    // DELETE
    public boolean deletePayment(int paymentID) {

        String sql =
                "DELETE FROM payments WHERE PaymentID = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, paymentID);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}