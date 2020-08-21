package com.tr.springcloud.customer.controller;

import com.tr.springcloud.customer.entity.Customer;
import com.tr.springcloud.customer.jpa.CustomerRepository;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author TR
 * @version 1.0
 * @date 8/20/2020 3:56 PM
 */
@Api(tags = "Customer")
@RestController
public class CustomerController {

    @Resource
    private CustomerRepository customerRepository;

    @GetMapping("/customers/{id}")
    public Customer findOne(@PathVariable Integer id) {
        return customerRepository.findById(id).get();
    }

    @PostMapping("/customers")
    public void save(@RequestBody Customer customer) {
        customerRepository.save(customer);
    }

    @GetMapping("/customers")
    public List<Customer> finaAll() {
        return customerRepository.findAll();
    }

    @DeleteMapping("/customers/{id}")
    public void delete(@PathVariable Integer id) {
        customerRepository.deleteById(id);
    }

}
