package sms_backend.dao;

import sms_backend.model.Service;
import sms_backend.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAO {

    // CREATE
    public int addService(Service service) {

        String sql = """
                INSERT INTO services
                (ServiceName, ServiceDescription, Tier,
                 PricePerBillingCycle)
                VALUES (?, ?, ?, ?)
                """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, service.getServiceName());
            ps.setString(2, service.getServiceDescription());
            ps.setString(3, service.getTier());
            ps.setDouble(4, service.getPricePerBillingCycle());


            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    service.setServiceID(id);
                    return id;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }


    // READ
    public Service getServiceById(Integer serviceID) {

        String sql =
                "SELECT * FROM services WHERE ServiceID = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, serviceID);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Service service = new Service();

                    service.setServiceID(rs.getInt("ServiceID"));
                    service.setServiceName(rs.getString("ServiceName"));
                    service.setServiceDescription(
                            rs.getString("ServiceDescription"));
                    service.setTier(rs.getString("Tier"));
                    service.setPricePerBillingCycle(
                            rs.getDouble("PricePerBillingCycle"));

                    return service;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    // READ ALL
    public List<Service> getAllServices() {

        List<Service> services = new ArrayList<>();

        String sql = "SELECT * FROM services";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Service service = new Service();

                service.setServiceID(rs.getInt("ServiceID"));
                service.setServiceName(rs.getString("ServiceName"));
                service.setServiceDescription(
                        rs.getString("ServiceDescription"));
                service.setTier(rs.getString("Tier"));
                service.setPricePerBillingCycle(
                        rs.getDouble("PricePerBillingCycle"));

                services.add(service);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return services;
    }


    // UPDATE
    public boolean updateService(Service service) {

        String sql = """
                UPDATE services
                SET ServiceName = ?,
                    ServiceDescription = ?,
                    Tier = ?,
                    PricePerBillingCycle = ?
                WHERE ServiceID = ?
                """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, service.getServiceName());
            ps.setString(2, service.getServiceDescription());
            ps.setString(3, service.getTier());
            ps.setDouble(4, service.getPricePerBillingCycle());

            ps.setInt(5, service.getServiceID());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    // DELETE
    public boolean deleteService(Integer serviceID) {

        String sql =
                "DELETE FROM services WHERE ServiceID = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, serviceID);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}