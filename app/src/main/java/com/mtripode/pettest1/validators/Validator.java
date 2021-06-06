package com.mtripode.pettest1.validators;

import java.util.HashMap;

public interface Validator {

    public boolean validate(Object o, HashMap<String, Object> elements);
}
