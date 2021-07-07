package com.mtripode.pettest1.validators;

import android.widget.TextView;

import com.mtripode.pettest1.abscomponent.StringUtils;
import com.mtripode.pettest1.entity.Animal;
import com.mtripode.pettest1.errors.ValidatorError;

import java.util.Date;
import java.util.HashMap;

public class AnimalValidator implements Validator {
    @Override
    public boolean validate(Object o, HashMap<String, Object> elements) throws ValidatorError {

        Boolean hasError = false;
       TextView editTextAddUpdatePetName = (TextView) elements.get("editTextAddUpdatePetName");
       TextView editTextAddUpdatePetSex = (TextView) elements.get("editTextAddUpdatePetSex");
       TextView editTextAddUpdatePetSpecie = (TextView) elements.get("editTextAddUpdatePetSpecie");
       TextView petRegisterTextDateBirthday = (TextView) elements.get("petRegisterTextDateBirthday");
       Date dateBirthday = (Date) elements.get("dateBirthday");

       Animal animal = (Animal) o;

        if (StringUtils.isEmpty(animal.getName())){
            editTextAddUpdatePetName.setError("Este campo es requerido");
            hasError = true;
        }

        if (StringUtils.isEmpty(animal.getSex())){
            editTextAddUpdatePetSex.setError("Este campo es requerido");
            hasError = true;
        }

        if (StringUtils.isEmpty(animal.getSpecie())){
            editTextAddUpdatePetSpecie.setError("Este campo es requerido");
            hasError = true;
        }

        if (dateBirthday == null){
            hasError = true;
            petRegisterTextDateBirthday.setError("Selecciona una fecha");
        }

        return hasError;
    }
}
