package com.mtripode.pettest1.service;

import com.mtripode.pettest1.entity.Customer;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RestInterface {

    @Headers("Content-Type: application/json")
    @POST("rest/customer/create")
    Call<Customer> createEmployee(@Body Customer body);

    @GET("rest/customer/findByEmail/{email}")
    Call<Customer> findCustomer(@Path("email") String email);

    @GET("rest/customer/findByUsername/{username}")
    Call<Customer> findCustomerByUserName(@Path("username") String username);
}
