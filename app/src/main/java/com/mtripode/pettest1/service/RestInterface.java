package com.mtripode.pettest1.service;

import com.mtripode.pettest1.entity.Animal;
import com.mtripode.pettest1.entity.Customer;
import com.mtripode.pettest1.entity.Doctor;

import java.util.Set;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RestInterface {

    @Headers("Content-Type: application/json")
    @POST("rest/customer/animal/createupdate")
    Call<Animal> createUdpateAnimal(@Body Animal animal);

    @Headers("Content-Type: application/json")
    @POST("rest/customer/update")
    Call<Customer> udpateEmployee(@Body Customer body);

    @Headers("Content-Type: application/json")
    @POST("rest/customer/create")
    Call<Customer> createEmployee(@Body Customer body);

    @Headers("Content-Type: application/json")
    @POST("rest/doctor/create")
    Call<Doctor> createDoctor(@Body Doctor body);

    @GET("rest/customer/findByEmail/{email}")
    Call<Customer> findCustomer(@Path("email") String email);

    @GET("rest/customer/findByUsername/{username}")
    Call<Customer> findCustomerByUserName(@Path("username") String username);

    @GET("rest/customer/animals/{customer}")
    Call<Set<Animal>> findAnimalsByCustomer(@Path("customer") Customer customer);

}
