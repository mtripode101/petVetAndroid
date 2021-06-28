package com.mtripode.pettest1.service;

import com.mtripode.pettest1.entity.Animal;
import com.mtripode.pettest1.entity.Customer;
import com.mtripode.pettest1.errors.ConnectionError;
import com.mtripode.pettest1.utils.HttpUtils;

import retrofit2.Call;
import retrofit2.Response;

public class AnimalServiceImpl implements AnimalService {
    @Override
    public Animal createAnimal(Animal animal, Customer customer) throws ConnectionError {
        {
            Call<Animal> userCall = HttpUtils.getRestInterface().createUdpateAnimal(animal, customer.getId());
            Animal animalRet = null;

            try
            {
                Response<Animal> response = userCall.execute();
                animalRet = response.body();

                //API response
            }
            catch (Exception ex)
            {
                throw new ConnectionError(ex.getMessage());
            }

            return animalRet;
        }
    }

    @Override
    public Animal updateAnimal(Animal animal, Customer customer) throws ConnectionError {
        return null;
    }
}
