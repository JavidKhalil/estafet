package com.estafet.repository;

import com.estafet.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CustomerRepository {

    private AtomicLong idCounter = new AtomicLong(1L);

    private Map<Long, Customer> customers = new HashMap<>();

    public void saveAndFlush(Customer customer) {
        customers.put(idCounter.getAndIncrement(), customer);
    }
}
