package com.mtripode.pettest1.validators;

import android.graphics.Color;
import android.widget.TextView;
import android.widget.Toast;

import com.mtripode.pettest1.abscomponent.StringUtils;
import com.mtripode.pettest1.entity.Customer;
import com.mtripode.pettest1.entity.Doctor;
import com.mtripode.pettest1.errors.ConnectionError;
import com.mtripode.pettest1.errors.ValidatorError;
import com.mtripode.pettest1.service.CustomerServiceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerValidator implements Validator {
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$";

    private static final String NORESULT = "noResults";
    private static final String MORE_THAN_ONE = "moreThanOne";

    private Pattern pattern;
    private Matcher matcher;

    private boolean validateUserEmail(String email) {
        return StringUtils.isEmpty(email) || !validateEmail(email);
    }


    private boolean validateEmail(String email) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @Override
    public boolean validate(Object o, HashMap<String, Object> elements ) throws ValidatorError {
        TextView editEmailAddress = (TextView) elements.get("editEmailAddress");
        Boolean hasError = false;
        if (o instanceof Customer){
            Customer customer = (Customer) o;

            hasError = validateCommonData(elements, hasError, customer);

            if (validateUserEmail(customer.getEmail())) {
                hasError = true;
                editEmailAddress.setError("Mail invalido");
            }
        }
        else if (o instanceof Doctor){
            Doctor doctor = (Doctor) o;
            hasError = validateCommonData(elements, hasError, doctor);
        }



        return hasError;
    }

    private Boolean validateCommonData(HashMap<String, Object> elements, Boolean hasError, Customer customer) {
        TextView textViewOwner = (TextView) elements.get("textViewOwner");
        TextView editPassword = (TextView) elements.get("editPassword");
        TextView editConfirmPassword = (TextView) elements.get("editConfirmPassword");
        TextView editEmailAddress = (TextView) elements.get("editEmailAddress");

        if (StringUtils.isEmpty(customer.getUsername())){
            textViewOwner.setError("Este campo es requerido");
            hasError = true;
        }

        if (verifyUserExists(customer, elements)) {
            hasError = true;
            textViewOwner.setError("Este usuario ya esta siendo utilizado.");
        }

        if (validateUsername(customer.getUsername())) {
            textViewOwner.setError("Usar entre 6 y 32 caracteres.");
            hasError = true;
        }

        if (validateGeneralEmail(customer, elements)) {
            hasError = true;
            editEmailAddress.setError("Este email ya esta siendo utilizado.");
        }

        if (StringUtils.isEmpty(customer.getPassword())){
            hasError = true;
            editPassword.setError("Usar entre 6 y 32 caracteres.");
        }
        if (validatePassword(customer.getPassword())) {
            hasError = true;
            editPassword.setError("Trate al menos 8 caracteres.");
        }

        if (validateConfirmPassword(customer.getPassword(), customer.getPasswordConfirm())) {
            hasError = true;
            editConfirmPassword.setError("Estos passwords no matchean.");
        }

        Date birthday = customer.getBirthday();
        datebirthValidate(birthday);
        return hasError;
    }

    private boolean validateGeneralEmail(Customer customer, HashMap<String, Object> elements) throws ValidatorError {
        CustomerServiceImpl createCustomerService = new CustomerServiceImpl();
        Customer cusEmail = null;

        try{
            cusEmail = createCustomerService.findCustomerSync(customer);
            if (cusEmail != null && (!StringUtils.isEmpty(cusEmail.getEmail())) && (cusEmail.getEmail().equalsIgnoreCase(CustomerValidator.MORE_THAN_ONE)
                    || cusEmail.getEmail().equalsIgnoreCase(customer.getEmail()))) {
                return true;
            }

        }
        catch (ConnectionError e){
            elements.put("connectionError", e.getMessage());
            throw new ValidatorError(e.getMessage());
        }


        return false;
    }
    private boolean validateConfirmPassword(String password, String passwordConfirm) {
        return !passwordConfirm.equals(password);
    }

    private boolean validatePassword(String password) {
        return password.length() < 8 || password.length() > 32;
    }

    private boolean validateUsername(String username) {
        return username.length() < 6 || username.length() > 32;
    }

    private void datebirthValidate( Date birthday) {
        if (birthday == null) {
        }
    }

    private boolean verifyUserExists(Customer customer, HashMap<String, Object> elements) throws ValidatorError {
        CustomerServiceImpl createCustomerService = new CustomerServiceImpl();
        Customer cusEmail = null;
        try{
            cusEmail = createCustomerService.findCustomerByUserName(customer);
            if (cusEmail != null && !StringUtils.isEmpty(cusEmail.getUsername()) && cusEmail.getUsername().equals(customer.getUsername())) {
                return true;
            }

        }
        catch (ConnectionError e){
            elements.put("connectionError", e.getMessage());
            throw new ValidatorError(e.getMessage());
        }


        return false;
    }



}
