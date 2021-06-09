package com.mtripode.pettest1.validators;

import com.mtripode.pettest1.errors.ValidatorError;

import java.util.HashMap;

public interface Validator {

    public boolean validate(Object o, HashMap<String, Object> elements) throws ValidatorError;
}
