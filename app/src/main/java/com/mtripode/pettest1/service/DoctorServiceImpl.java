package com.mtripode.pettest1.service;

import com.mtripode.pettest1.entity.Customer;
import com.mtripode.pettest1.entity.Doctor;
import com.mtripode.pettest1.errors.ConnectionError;
import com.mtripode.pettest1.jsonutils.CustomerDesrializer;
import com.mtripode.pettest1.utils.HttpUtils;

import java.util.Set;

import retrofit2.Call;
import retrofit2.Response;

public class DoctorServiceImpl implements DoctorService {

    @Override
    public Set<Doctor> getDoctorsByCustomer(Customer customer) {
        Call<Set<Doctor>> userCall = HttpUtils.getRestInterface().findDoctorsByCustomer(customer.getUsername());
        Set<Doctor> doctors = null;

        try
        {
            Response<Set<Doctor>> response = userCall.execute();
            doctors = response.body();

            //API response
        }
        catch (Exception ex)
        {
            throw new ConnectionError(ex.getMessage());
        }

        return doctors;
    }

}
