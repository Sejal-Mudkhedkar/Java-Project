package sms_backend.dao;

import sms_backend.model.Subscription;
import sms_backend.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionDAO {

    // CREATE
    public int addSubscription(Subscription subscription) {

        String sql = """
                INSERT INTO subscriptions
                (CustomerID, ServiceID, SubscriptionStartDate,
                 SubscriptionEndDate, RenewalDate, Status)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, subscription.getCustomerID());
            ps.setInt(2, subscription.getServiceID());
            ps.setDate(3, subscription.getSubscriptionStartDate());
            ps.setDate(4, subscription.getSubscriptionEndDate());
            ps.setDate(5, subscription.getRenewalDate());
            ps.setString(6, subscription.getStatus());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    subscription.setSubscriptionID(id);
                    return id;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }


    // READ
    public Subscription getSubscriptionById(Integer subscriptionID) {

        String sql =
                "SELECT * FROM subscriptions WHERE SubscriptionID = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, subscriptionID);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Subscription subscription = new Subscription();

                    subscription.setSubscriptionID(
                            rs.getInt("SubscriptionID"));
                    subscription.setCustomerID(
                            rs.getInt("CustomerID"));
                    subscription.setServiceID(
                            rs.getInt("ServiceID"));
                    subscription.setSubscriptionStartDate(
                            rs.getDate("SubscriptionStartDate"));
                    subscription.setSubscriptionEndDate(
                            rs.getDate("SubscriptionEndDate"));
                    subscription.setRenewalDate(
                            rs.getDate("RenewalDate"));
                    subscription.setStatus(
                            rs.getString("Status"));

                    return subscription;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    // READ ALL
    public List<Subscription> getAllSubscriptions() {

        List<Subscription> subscriptions = new ArrayList<>();

        String sql = "SELECT * FROM subscriptions";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Subscription subscription = new Subscription();

                subscription.setSubscriptionID(
                        rs.getInt("SubscriptionID"));
                subscription.setCustomerID(
                        rs.getInt("CustomerID"));
                subscription.setServiceID(
                        rs.getInt("ServiceID"));
                subscription.setSubscriptionStartDate(
                        rs.getDate("SubscriptionStartDate"));
                subscription.setSubscriptionEndDate(
                        rs.getDate("SubscriptionEndDate"));
                subscription.setRenewalDate(
                        rs.getDate("RenewalDate"));
                subscription.setStatus(
                        rs.getString("Status"));

                subscriptions.add(subscription);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return subscriptions;
    }


    // UPDATE
    public boolean updateSubscription(Subscription subscription) {

        String sql = """
                UPDATE subscriptions
                SET CustomerID = ?,
                    ServiceID = ?,
                    SubscriptionStartDate = ?,
                    SubscriptionEndDate = ?,
                    RenewalDate = ?,
                    Status = ?
                WHERE SubscriptionID = ?
                """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, subscription.getCustomerID());
            ps.setInt(2, subscription.getServiceID());
            ps.setDate(3, subscription.getSubscriptionStartDate());
            ps.setDate(4, subscription.getSubscriptionEndDate());
            ps.setDate(5, subscription.getRenewalDate());
            ps.setString(6, subscription.getStatus());
            ps.setInt(7, subscription.getSubscriptionID());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    // DELETE
    public boolean deleteSubscription(Integer subscriptionID) {

        String sql =
                "DELETE FROM subscriptions WHERE SubscriptionID = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, subscriptionID);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}