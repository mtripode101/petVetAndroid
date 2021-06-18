package com.mtripode.pettest1.data;

import com.mtripode.pettest1.data.model.LoggedInUser;
import com.mtripode.pettest1.entity.Customer;

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
            Customer customer = new Customer();
            customer.setUsername(username);
            customer.setPassword(password);
            return new Result.Success<>(customer);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}