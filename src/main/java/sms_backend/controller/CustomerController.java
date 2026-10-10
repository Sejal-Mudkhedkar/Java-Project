package sms_backend.controller;

import org.springframework.web.bind.annotation.*;
import sms_backend.dao.CustomerDAO;
import sms_backend.model.Customer;

import java.util.List;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "*")
public class CustomerController {

    private final CustomerDAO customerDAO;

    public CustomerController() {
        this.customerDAO = new CustomerDAO();
    }

    // GET ALL CUSTOMERS
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    // GET CUSTOMER BY ID
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return customerDAO.getCustomerById(id);
    }

    // ADD CUSTOMER
    @PostMapping
    public int addCustomer(@RequestBody Customer customer) {
        return customerDAO.addCustomer(customer);
    }

    // UPDATE CUSTOMER
    @PutMapping("/{id}")
    public boolean updateCustomer(
            @PathVariable int id,
            @RequestBody Customer customer) {

        customer.setCustomerID(id);

        return customerDAO.updateCustomer(customer);
    }

    // DELETE CUSTOMER
    @DeleteMapping("/{id}")
    public boolean deleteCustomer(@PathVariable int id) {
        return customerDAO.deleteCustomer(id);
    }
}