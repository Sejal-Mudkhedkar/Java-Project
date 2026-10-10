package sms_backend.dao;

import sms_backend.model.Billing;
import sms_backend.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillingDAO {

    // CREATE
    public int addBilling(Billing billing) {

        String sql = """
                INSERT INTO billing
                (SubscriptionID, BillingDate, AmountBilled,
                 PaymentDueDate, PaymentStatus)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, billing.getSubscriptionID());
            ps.setDate(2, billing.getBillingDate());
            ps.setBigDecimal(3, billing.getAmountBilled());
            ps.setDate(4, billing.getPaymentDueDate());
            ps.setString(5, billing.getPaymentStatus());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    billing.setBillID(id);
                    return id;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }


    // READ
    public Billing getBillingById(Integer billID) {

        String sql =
                "SELECT * FROM billing WHERE BillID = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, billID);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Billing billing = new Billing();

                    billing.setBillID(rs.getInt("BillID"));
                    billing.setSubscriptionID(
                            rs.getInt("SubscriptionID"));
                    billing.setBillingDate(
                            rs.getDate("BillingDate"));
                    billing.setAmountBilled(
                            rs.getBigDecimal("AmountBilled"));
                    billing.setPaymentDueDate(
                            rs.getDate("PaymentDueDate"));
                    billing.setPaymentStatus(
                            rs.getString("PaymentStatus"));

                    return billing;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    // READ ALL
    public List<Billing> getAllBilling() {

        List<Billing> bills = new ArrayList<>();

        String sql = "SELECT * FROM billing";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Billing billing = new Billing();

                billing.setBillID(rs.getInt("BillID"));
                billing.setSubscriptionID(
                        rs.getInt("SubscriptionID"));
                billing.setBillingDate(
                        rs.getDate("BillingDate"));
                billing.setAmountBilled(
                        rs.getBigDecimal("AmountBilled"));
                billing.setPaymentDueDate(
                        rs.getDate("PaymentDueDate"));
                billing.setPaymentStatus(
                        rs.getString("PaymentStatus"));

                bills.add(billing);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bills;
    }


    // UPDATE
    public boolean updateBilling(Billing billing) {

        String sql = """
                UPDATE billing
                SET SubscriptionID = ?,
                    BillingDate = ?,
                    AmountBilled = ?,
                    PaymentDueDate = ?,
                    PaymentStatus = ?
                WHERE BillID = ?
                """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, billing.getSubscriptionID());
            ps.setDate(2, billing.getBillingDate());
            ps.setBigDecimal(3, billing.getAmountBilled());
            ps.setDate(4, billing.getPaymentDueDate());
            ps.setString(5, billing.getPaymentStatus());
            ps.setInt(6, billing.getBillID());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    // DELETE
    public boolean deleteBilling(Integer billID) {

        String sql =
                "DELETE FROM billing WHERE BillID = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, billID);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}