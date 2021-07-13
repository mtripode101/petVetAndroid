package com.mtripode.pettest1.service;

import com.mtripode.pettest1.entity.Customer;
import com.mtripode.pettest1.entity.Doctor;
import com.mtripode.pettest1.errors.ConnectionError;
import com.mtripode.pettest1.jsonutils.CustomerDesrializer;
import com.mtripode.pettest1.utils.HttpUtils;

import java.net.ConnectException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public Customer createCustomer(Customer customer) throws ConnectionError {
        Call<Customer> userCall = HttpUtils.getRestInterfaceWithTypeAdapter(Customer.class, new CustomerDesrializer()).createEmployee(customer);
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
    public Customer createDoctorSyn(Doctor doctor) throws ConnectionError {
        {
            Call<Doctor> userCall = HttpUtils.getRestInterfaceWithTypeAdapter(Customer.class, new CustomerDesrializer()).createDoctor(doctor);
            Doctor doctorRet = null;

            try
            {
                Response<Doctor> response = userCall.execute();
                doctorRet = response.body();

                //API response
            }
            catch (Exception ex)
            {
                throw new ConnectionError(ex.getMessage());
            }

            return doctorRet;
        }
    }

    @Override
    public Customer updateCustomerSyn(Customer customer) throws ConnectionError {
        {
            Call<Customer> userCall = HttpUtils.getRestInterfaceWithTypeAdapter(Customer.class, new CustomerDesrializer()).udpateEmployee(customer);
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
        Call<Customer> userCall = HttpUtils.getRestInterfaceWithTypeAdapter(Customer.class, new CustomerDesrializer()).findCustomer(customer.getEmail());
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

    @Override
    public Customer findCustomerByUserName(Customer customer) throws ConnectionError {
        Call<Customer> userCall = HttpUtils.getRestInterfaceWithTypeAdapter(Customer.class, new CustomerDesrializer()).findCustomerByUserName(customer.getUsername());
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
