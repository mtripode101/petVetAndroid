package com.mtripode.pettest1.service;

import com.mtripode.pettest1.entity.Animal;
import com.mtripode.pettest1.entity.Customer;
import com.mtripode.pettest1.errors.ConnectionError;

public interface AnimalService {

    public Animal createAnimal (Animal animal, Customer customer) throws ConnectionError;

    public Animal updateAnimal (Animal animal, Customer customer) throws ConnectionError;
}
