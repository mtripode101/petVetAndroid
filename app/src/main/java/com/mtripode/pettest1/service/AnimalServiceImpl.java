package com.mtripode.pettest1.service;

import com.mtripode.pettest1.entity.Animal;
import com.mtripode.pettest1.entity.Customer;
import com.mtripode.pettest1.errors.ConnectionError;
import com.mtripode.pettest1.utils.HttpUtils;

import java.util.Set;

import retrofit2.Call;
import retrofit2.Response;

public class AnimalServiceImpl implements AnimalService {
    @Override
    public Animal createAnimal(Animal animal) throws ConnectionError {
        {
            Call<Animal> userCall = HttpUtils.getRestInterface().createUdpateAnimal(animal);
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
    public Animal updateAnimal(Animal animal) throws ConnectionError {
        {
            Call<Animal> userCall = HttpUtils.getRestInterface().updateAnimal(animal);
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
    public Set<Animal> getAnimalsByOwner(Customer owner) throws ConnectionError {
        {
            Call<Set<Animal>> userCall = HttpUtils.getRestInterface().findAnimalsByCustomer(owner.getUsername());
            Set<Animal> animalsRet = null;

            try
            {
                Response<Set<Animal>> response = userCall.execute();
                animalsRet = response.body();

                //API response
            }
            catch (Exception ex)
            {
                throw new ConnectionError(ex.getMessage());
            }

            return animalsRet;
        }
    }
}
