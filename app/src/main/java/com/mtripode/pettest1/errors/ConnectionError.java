package com.mtripode.pettest1.errors;

public class ConnectionError extends Error {

    public ConnectionError (){
        super();
    }

    public ConnectionError(String msj){
        super(msj);
    }

}
