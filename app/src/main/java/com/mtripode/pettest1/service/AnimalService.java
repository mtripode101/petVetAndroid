package com.mtripode.pettest1.service;

import com.mtripode.pettest1.entity.Animal;
import com.mtripode.pettest1.entity.Customer;
import com.mtripode.pettest1.errors.ConnectionError;

import java.util.Set;

public interface AnimalService {

    public Animal createAnimal (Animal animal) throws ConnectionError;

    public Animal updateAnimal (Animal animal) throws ConnectionError;

    public Set<Animal> getAnimalsByOwner (Customer owner) throws ConnectionError;

    public Animal removeAnimal (Animal animal) throws  ConnectionError;
}
