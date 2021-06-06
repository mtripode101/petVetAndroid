package com.mtripode.pettest1.service;

import com.mtripode.pettest1.entity.Customer;

public interface CustomerService {

    public Customer createCustomer (Customer customer);

    public Customer findCustomer (Customer customer);

    public Customer findCustomerSync (Customer customer);
}
