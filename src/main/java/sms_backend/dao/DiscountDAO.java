package sms_backend.dao;

import sms_backend.model.Discount;
import sms_backend.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DiscountDAO {

    // CREATE
    public int addDiscount(Discount discount) {

        String sql = """
                INSERT INTO discounts
                (ServiceID, DiscountCode, DiscountAmount,
                 ValidFrom, ValidTill, DiscountType)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, discount.getServiceID());
            ps.setString(2, discount.getDiscountCode());
            ps.setDouble(3, discount.getDiscountAmount());
            ps.setDate(4, discount.getValidFrom());
            ps.setDate(5, discount.getValidTill());
            ps.setString(6, discount.getDiscountType());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    discount.setDiscountID(id);
                    return id;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }


    // READ
    public Discount getDiscountById(int discountID) {

        String sql =
                "SELECT * FROM discounts WHERE DiscountID = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, discountID);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Discount discount = new Discount();

                    discount.setDiscountID(
                            rs.getInt("DiscountID"));
                    discount.setServiceID(
                            rs.getInt("ServiceID"));
                    discount.setDiscountCode(
                            rs.getString("DiscountCode"));
                    discount.setDiscountAmount(
                            rs.getDouble("DiscountAmount"));
                    discount.setValidFrom(
                            rs.getDate("ValidFrom"));
                    discount.setValidTill(
                            rs.getDate("ValidTill"));
                    discount.setDiscountType(
                            rs.getString("DiscountType"));

                    return discount;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    // READ ALL
    public List<Discount> getAllDiscounts() {

        List<Discount> discounts = new ArrayList<>();

        String sql = "SELECT * FROM discounts";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Discount discount = new Discount();

                discount.setDiscountID(
                        rs.getInt("DiscountID"));
                discount.setServiceID(
                        rs.getInt("ServiceID"));
                discount.setDiscountCode(
                        rs.getString("DiscountCode"));
                discount.setDiscountAmount(
                        rs.getDouble("DiscountAmount"));
                discount.setValidFrom(
                        rs.getDate("ValidFrom"));
                discount.setValidTill(
                        rs.getDate("ValidTill"));
                discount.setDiscountType(
                        rs.getString("DiscountType"));

                discounts.add(discount);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return discounts;
    }


    // UPDATE
    public boolean updateDiscount(Discount discount) {

        String sql = """
                UPDATE discounts
                SET ServiceID = ?,
                    DiscountCode = ?,
                    DiscountAmount = ?,
                    ValidFrom = ?,
                    ValidTill = ?,
                    DiscountType = ?
                WHERE DiscountID = ?
                """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, discount.getServiceID());
            ps.setString(2, discount.getDiscountCode());
            ps.setDouble(3, discount.getDiscountAmount());
            ps.setDate(4, discount.getValidFrom());
            ps.setDate(5, discount.getValidTill());
            ps.setString(6, discount.getDiscountType());
            ps.setInt(7, discount.getDiscountID());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    // DELETE
    public boolean deleteDiscount(int discountID) {

        String sql =
                "DELETE FROM discounts WHERE DiscountID = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, discountID);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}