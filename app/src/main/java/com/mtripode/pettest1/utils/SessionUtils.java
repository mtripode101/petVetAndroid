package com.mtripode.pettest1.utils;

import com.mtripode.pettest1.entity.Customer;

public class SessionUtils {

    private static SessionUtils instance;
    private Customer customer;

    public static SessionUtils getInstance (){
        if (instance == null){
            instance = new SessionUtils();
        }

        return instance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
