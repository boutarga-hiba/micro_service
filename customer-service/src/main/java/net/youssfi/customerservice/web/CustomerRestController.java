package net.youssfi.customerservice.web;

import net.youssfi.customerservice.entities.Customer;
import net.youssfi.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Optional<Customer> existing = customerRepository.findById(id);
        if (existing.isPresent()) {
            customer.setId(id);
            return customerRepository.save(customer);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerRepository.deleteById(id);
    }
} 