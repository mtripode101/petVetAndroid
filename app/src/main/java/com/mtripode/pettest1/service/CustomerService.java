package com.mtripode.pettest1.service;

import com.mtripode.pettest1.entity.Customer;
import com.mtripode.pettest1.errors.ConnectionError;

public interface CustomerService {

    public Customer createCustomer (Customer customer) throws ConnectionError;

    public Customer findCustomer (Customer customer) throws ConnectionError;

    public Customer findCustomerSync (Customer customer) throws ConnectionError;
}
