package com.tr.springcloud.customer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TR
 * @version 1.0
 * @date 8/20/2020 3:56 PM
 */
@RestController
public class CustomerController {

    @GetMapping("/test")
    public String testCustomer() {
        return "Customer Success!";
    }

}
