package sms_backend.controller;

import org.springframework.web.bind.annotation.*;
import sms_backend.dao.ServiceDAO;
import sms_backend.model.Service;

import java.util.List;

@RestController
@RequestMapping("/services")
@CrossOrigin(origins = "http://localhost:3000")
public class ServiceController {

    private final ServiceDAO serviceDAO;

    public ServiceController() {
        this.serviceDAO = new ServiceDAO();
    }

    // GET ALL SERVICES
    @GetMapping
    public List<Service> getAllServices() {
        return serviceDAO.getAllServices();
    }

    // GET SERVICE BY ID
    @GetMapping("/{id}")
    public Service getServiceById(@PathVariable int id) {
        return serviceDAO.getServiceById(id);
    }

    // CREATE SERVICE
    @PostMapping
    public int addService(@RequestBody Service service) {
        return serviceDAO.addService(service);
    }

    // UPDATE SERVICE
    @PutMapping("/{id}")
    public boolean updateService(
            @PathVariable int id,
            @RequestBody Service service) {

        service.setServiceID(id);
        return serviceDAO.updateService(service);
    }

    // DELETE SERVICE
    @DeleteMapping("/{id}")
    public boolean deleteService(@PathVariable int id) {
        return serviceDAO.deleteService(id);
    }
}