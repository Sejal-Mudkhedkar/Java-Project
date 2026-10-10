package sms_backend.dao;

import sms_backend.model.ServiceProvider;
import sms_backend.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceProviderDAO {

    // CREATE
    public int addServiceProvider(ServiceProvider provider) {

        String sql = """
                INSERT INTO serviceproviders
                (ProviderName, ProviderContact, ProviderEmail)
                VALUES (?, ?, ?)
                """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, provider.getProviderName());
            ps.setString(2, provider.getProviderContact());
            ps.setString(3, provider.getProviderEmail());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    provider.setProviderID(id);
                    return id;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }


    // READ
    public ServiceProvider getServiceProviderById(int providerID) {

        String sql =
                "SELECT * FROM serviceproviders WHERE ProviderID = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, providerID);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    ServiceProvider provider = new ServiceProvider();

                    provider.setProviderID(rs.getInt("ProviderID"));
                    provider.setProviderName(rs.getString("ProviderName"));
                    provider.setProviderContact(rs.getString("ProviderContact"));
                    provider.setProviderEmail(rs.getString("ProviderEmail"));

                    return provider;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    // READ ALL
    public List<ServiceProvider> getAllServiceProviders() {

        List<ServiceProvider> providers = new ArrayList<>();

        String sql = "SELECT * FROM serviceproviders";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                ServiceProvider provider = new ServiceProvider();

                provider.setProviderID(rs.getInt("ProviderID"));
                provider.setProviderName(rs.getString("ProviderName"));
                provider.setProviderContact(rs.getString("ProviderContact"));
                provider.setProviderEmail(rs.getString("ProviderEmail"));

                providers.add(provider);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return providers;
    }


    // UPDATE
    public boolean updateServiceProvider(ServiceProvider provider) {

        String sql = """
                UPDATE serviceproviders
                SET ProviderName = ?,
                    ProviderContact = ?,
                    ProviderEmail = ?
                WHERE ProviderID = ?
                """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, provider.getProviderName());
            ps.setString(2, provider.getProviderContact());
            ps.setString(3, provider.getProviderEmail());
            ps.setInt(4, provider.getProviderID());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    // DELETE
    public boolean deleteServiceProvider(int providerID) {

        String sql =
                "DELETE FROM serviceproviders WHERE ProviderID = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, providerID);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}