package net.youssfi.billingservice.web;

import net.youssfi.billingservice.entities.Bill;
import net.youssfi.billingservice.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bills")
public class BillCrudRestController {
    @Autowired
    private BillRepository billRepository;

    @GetMapping
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    @GetMapping("/{id}")
    public Bill getBillById(@PathVariable Long id) {
        return billRepository.findById(id).orElse(null);
    }

    @PostMapping("/saveBill")
    public Bill createBill(@RequestBody Bill bill) {
        return billRepository.save(bill);
    }

    @PutMapping("/{id}")
    public Bill updateBill(@PathVariable Long id, @RequestBody Bill bill) {
        Optional<Bill> existing = billRepository.findById(id);
        if (existing.isPresent()) {
            bill.setId(id);
            return billRepository.save(bill);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteBill(@PathVariable Long id) {
        billRepository.deleteById(id);
    }
} 