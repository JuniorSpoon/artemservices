package com.artemas.customer.service;

import com.artemas.customer.requests.CustomerRegistrationRequest;
import com.artemas.customer.repository.CustomerRepository;
import com.artemas.customer.entity.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        // todo: check if email is valid
        // todo: check if email not taken
        customerRepository.save(customer);
    }
}
