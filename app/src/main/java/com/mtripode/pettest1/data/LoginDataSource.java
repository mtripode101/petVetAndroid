package com.mtripode.pettest1.data;

import com.mtripode.pettest1.data.model.LoggedInUser;
import com.mtripode.pettest1.entity.Customer;
import com.mtripode.pettest1.service.CustomerServiceImpl;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<Customer> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
            LoggedInUser fakeUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            "Jane Doe");
            CustomerServiceImpl customerService = new CustomerServiceImpl();
            Customer customer = new Customer();
            customer.setUsername(username);
            customer.setPassword(password);
            Customer customerRes =  customerService.findCustomerByUserName(customer);
            return new Result.Success<>(customerRes);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}