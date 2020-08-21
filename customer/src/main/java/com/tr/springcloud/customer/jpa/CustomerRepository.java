package com.tr.springcloud.customer.jpa;

import com.tr.springcloud.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author TR
 * @version 1.0
 * @date 8/21/2020 11:53 AM
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}