package sms_backend.controller;

import org.springframework.web.bind.annotation.*;
import sms_backend.dao.SubscriptionDAO;
import sms_backend.model.Subscription;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
@CrossOrigin(origins = "http://localhost:3000")
public class SubscriptionController {

    private final SubscriptionDAO subscriptionDAO;

    public SubscriptionController() {
        this.subscriptionDAO = new SubscriptionDAO();
    }

    // GET ALL SUBSCRIPTIONS
    @GetMapping
    public List<Subscription> getAllSubscriptions() {
        return subscriptionDAO.getAllSubscriptions();
    }

    // GET SUBSCRIPTION BY ID
    @GetMapping("/{id}")
    public Subscription getSubscriptionById(@PathVariable Integer id) {
        return subscriptionDAO.getSubscriptionById(id);
    }

    // ADD SUBSCRIPTION
    @PostMapping
    public Integer addSubscription(@RequestBody Subscription subscription) {
        return subscriptionDAO.addSubscription(subscription);
    }

    // UPDATE SUBSCRIPTION
    @PutMapping("/{id}")
    public boolean updateSubscription(
            @PathVariable Integer id,
            @RequestBody Subscription subscription) {

        subscription.setSubscriptionID(id);
        return subscriptionDAO.updateSubscription(subscription);
    }

    // DELETE SUBSCRIPTION
    @DeleteMapping("/{id}")
    public boolean deleteSubscription(@PathVariable Integer id) {
        return subscriptionDAO.deleteSubscription(id);
    }
}