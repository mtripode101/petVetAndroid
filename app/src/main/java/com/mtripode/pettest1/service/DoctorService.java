package com.mtripode.pettest1.service;

import com.mtripode.pettest1.entity.Customer;
import com.mtripode.pettest1.entity.Doctor;

import java.util.Set;

interface DoctorService {

    public Set<Doctor> getDoctorsByCustomer (Customer customer);
}
