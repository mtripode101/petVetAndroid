package com.mtripode.pettest1.validators;

import com.mtripode.pettest1.entity.Customer;
import com.mtripode.pettest1.errors.ConnectionError;
import com.mtripode.pettest1.service.CustomerServiceImpl;

import java.util.HashMap;

public class LoginValidator implements Validator {
    @Override
    public boolean validate(Object o, HashMap<String, Object> elements) {
        Customer customerLogin = (Customer) o;
        Boolean hasError = false;
        if (customerLogin == null){
            elements.put("customerEmpty", "Customer empty");
            return false;
        }

        CustomerServiceImpl createCustomerService = new CustomerServiceImpl();
        Customer customerRet = null;
        try{
           customerRet = createCustomerService.findCustomerByUserName(customerLogin);
        }
        catch (ConnectionError e){
            elements.put("customerEmpty", e.getMessage());
            return false;
        }

        if (customerRet != null) {
            validateCustomerFound(customerLogin, customerRet);
        }
        else {
            elements.put("customerEmpty", "Customer is empty");
            return false;
        }
        return false;
    }

    private boolean validateCustomerFound(Customer customerLogin, Customer customer) {
        if (!customer.isEnable()) {
            return false;
        }

        if (validateConfirmPassword(customerLogin.getPassword(), customer.getPassword())) {
            return false;
        }

        return true;
    }

    private boolean validateConfirmPassword(String password, String passwordLogin) {
        return !password.equals(passwordLogin);
    }
}
