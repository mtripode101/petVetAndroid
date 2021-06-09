package com.mtripode.pettest1.errors;

public class ValidatorError extends Error {

    public ValidatorError (){
        super();
    }

    public ValidatorError (String msj) {
        super(msj);
    }

}
