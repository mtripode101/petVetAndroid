package com.mtripode.pettest1.data;

import com.mtripode.pettest1.data.model.LoggedInUser;
import com.mtripode.pettest1.entity.Customer;
import com.mtripode.pettest1.errors.ConnectionError;

import java.io.IOException;

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */
public class LoginRepository {

    private static volatile LoginRepository instance;

    private LoginDataSource dataSource;

    // If user credentials will be cached in local storage, it is recommended it be encrypted
    // @see https://developer.android.com/training/articles/keystore
    private LoggedInUser user = null;

    // private constructor : singleton access
    private LoginRepository(LoginDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static LoginRepository getInstance(LoginDataSource dataSource) {
        if (instance == null) {
            instance = new LoginRepository(dataSource);
        }
        return instance;
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    public void logout() {
        user = null;
        dataSource.logout();
    }

    private void setLoggedInUser(Customer customer) {
        this.user = user;
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }

    public Result<Customer> login(String username, String password) {
        // handle login
        Result<Customer> result =null;
        try{
            result = dataSource.login(username, password);
            if (result instanceof Result.Success) {
                setLoggedInUser(((Result.Success<Customer>) result).getData());
            }
        }
        catch (ConnectionError e){
            return new Result.Error(new IOException("Error logging in", e));
        }

        return result;
    }
}