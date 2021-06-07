package com.mtripode.pettest1.validators;

import com.mtripode.pettest1.entity.Customer;
import com.mtripode.pettest1.errors.ConnectionError;
import com.mtripode.pettest1.service.CustomerServiceImpl;

import java.util.HashMap;

public class LoginValidator implements Validator {
    public static final String CUSTOMER_ERROR = "customerError";

    @Override
    public boolean validate(Object o, HashMap<String, Object> elements) {
        Customer customerLogin = (Customer) o;
        if (customerLogin == null){
            elements.put(CUSTOMER_ERROR, "Customer does not exist");
            return false;
        }

        CustomerServiceImpl createCustomerService = new CustomerServiceImpl();
        Customer customerRet = null;
        try{
           customerRet = createCustomerService.findCustomerByUserName(customerLogin);
        }
        catch (ConnectionError e){
            elements.put(CUSTOMER_ERROR, e.getMessage());
            return false;
        }

        if (customerRet != null) {
            if (!validateCustomerFound(customerLogin, customerRet, elements)){
                return false;
            }
        }
        else {
            elements.put(CUSTOMER_ERROR, "Customer does not exist");
            return false;
        }
        return true;
    }

    private boolean validateCustomerFound(Customer customerLogin, Customer customer, HashMap<String, Object> elements ) {
        if (!customer.isEnable()) {
            elements.put(CUSTOMER_ERROR, "User "+customer.getUsername()+" is disabled");
            return false;
        }

        if (validateConfirmPassword(customerLogin.getPassword(), customer.getPassword())) {
            elements.put(CUSTOMER_ERROR, "Passwords not match");
            return false;
        }

        return true;
    }

    private boolean validateConfirmPassword(String password, String passwordLogin) {
        return !password.equals(passwordLogin);
    }
}
