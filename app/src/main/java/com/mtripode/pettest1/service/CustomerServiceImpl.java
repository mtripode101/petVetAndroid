package com.mtripode.pettest1.service;

import com.mtripode.pettest1.entity.Customer;
import com.mtripode.pettest1.utils.HttpUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public Customer createCustomer(Customer customer) {
        Call<Customer> userCall = HttpUtils.getRestInterface().createEmployee(customer);
        Customer customerRet = null;
        userCall.enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call<Customer> call, Response<Customer> response) {
                System.err.println("Here");
                int statusCode = response.code();
                Customer customer2 = response.body();
            }

            @Override
            public void onFailure(Call<Customer> call, Throwable t) {
                System.err.println("Here");
            }

        });
        return customerRet;
    }

    @Override
    public Customer findCustomer(Customer customer) {
        Call<Customer> userCall = HttpUtils.getRestInterface().findCustomer(customer.getEmail());
        Customer customerRet = null;
        userCall.enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call<Customer> call, Response<Customer> response) {
                System.err.println("Here");
                int statusCode = response.code();
                Customer customer2 = response.body();
                System.err.println("UserName "+customer2.getUsername());
            }

            @Override
            public void onFailure(Call<Customer> call, Throwable t) {
                System.err.println("Here");
            }

        });
        return customerRet;
    }

    @Override
    public Customer findCustomerSync(Customer customer) {
        Call<Customer> userCall = HttpUtils.getRestInterface().findCustomer(customer.getEmail());
        Customer customerRet = null;

        try
        {
            Response<Customer> response = userCall.execute();
            customerRet = response.body();

            //API response
        }
        catch (Exception ex)
        {
            return new Customer();
        }

        return customerRet;
    }
}
