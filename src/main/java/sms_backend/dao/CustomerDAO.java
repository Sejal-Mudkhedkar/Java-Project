package sms_backend.dao;

import sms_backend.model.Customer;
import sms_backend.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    // CREATE
    public int addCustomer(Customer customer) {

        String sql = """
                INSERT INTO Customers
                (CustomerName, CustomerEmail, ContactNumber,
                 Address, SignupDate, Status)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, customer.getCustomerName());
            ps.setString(2, customer.getCustomerEmail());
            ps.setString(3, customer.getContactNumber());
            ps.setString(4, customer.getAddress());
            ps.setDate(5, customer.getSignupDate());
            ps.setString(6, customer.getStatus());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    customer.setCustomerID(id);
                    return id;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }


    // READ - Get one customer
    public Customer getCustomerById(int customerID) {

        String sql =
                "SELECT * FROM customers WHERE CustomerID = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, customerID);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    Customer customer = new Customer();

                    customer.setCustomerID(rs.getInt("CustomerID"));
                    customer.setCustomerName(rs.getString("CustomerName"));
                    customer.setCustomerEmail(rs.getString("CustomerEmail"));
                    customer.setContactNumber(rs.getString("ContactNumber"));
                    customer.setAddress(rs.getString("Address"));
                    customer.setSignupDate(rs.getDate("SignupDate"));
                    customer.setStatus(rs.getString("Status"));

                    return customer;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    // READ - Get all customers
    public List<Customer> getAllCustomers() {

        List<Customer> customers = new ArrayList<>();

        String sql = "SELECT * FROM Customers";

        try (Connection con = DBConnection.getConnection()) {

            System.out.println("Connected database: "
                    + con.getCatalog());

            try (PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    Customer customer = new Customer();

                    customer.setCustomerID(rs.getInt("CustomerID"));
                    customer.setCustomerName(rs.getString("CustomerName"));
                    customer.setCustomerEmail(rs.getString("CustomerEmail"));
                    customer.setContactNumber(rs.getString("ContactNumber"));
                    customer.setAddress(rs.getString("Address"));
                    customer.setSignupDate(rs.getDate("SignupDate"));
                    customer.setStatus(rs.getString("Status"));

                    customers.add(customer);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }


    // UPDATE
    public boolean updateCustomer(Customer customer) {

        String sql = """
                UPDATE customers
                SET CustomerName = ?,
                    CustomerEmail = ?,
                    ContactNumber = ?,
                    Address = ?,
                    SignupDate = ?,
                    Status = ?
                WHERE CustomerID = ?
                """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, customer.getCustomerName());
            ps.setString(2, customer.getCustomerEmail());
            ps.setString(3, customer.getContactNumber());
            ps.setString(4, customer.getAddress());
            ps.setDate(5, customer.getSignupDate());
            ps.setString(6, customer.getStatus());
            ps.setInt(7, customer.getCustomerID());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    // DELETE
    public boolean deleteCustomer(int customerID) {

        String sql =
                "DELETE FROM customers WHERE CustomerID = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, customerID);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}