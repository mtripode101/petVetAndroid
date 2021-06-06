package com.mtripode.pettest1.service;

import com.mtripode.pettest1.entity.Customer;
import com.mtripode.pettest1.errors.ConnectionError;
import com.mtripode.pettest1.utils.HttpUtils;

import java.net.ConnectException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public Customer createCustomer(Customer customer) throws ConnectionError {
        Call<Customer> userCall = HttpUtils.getRestInterface().createEmployee(customer);
        Customer customerRet = null;
        userCall.enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call<Customer> call, Response<Customer> response) {
                System.err.println("Here 123");
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
    public Customer createCustomerSyn(Customer customer) throws ConnectionError {
        {
            Call<Customer> userCall = HttpUtils.getRestInterface().createEmployee(customer);
            Customer customerRet = null;

            try
            {
                Response<Customer> response = userCall.execute();
                customerRet = response.body();

                //API response
            }
            catch (Exception ex)
            {
                throw new ConnectionError(ex.getMessage());
            }

            return customerRet;
        }
    }

    @Override
    public Customer findCustomer(Customer customer) throws ConnectionError {
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
    public Customer findCustomerSync(Customer customer) throws ConnectionError {
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
            throw new ConnectionError(ex.getMessage());
        }

        return customerRet;
    }
}
