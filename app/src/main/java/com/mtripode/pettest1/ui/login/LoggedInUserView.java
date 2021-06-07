package com.mtripode.pettest1.ui.login;

import com.mtripode.pettest1.entity.Customer;

/**
 * Class exposing authenticated user details to the UI.
 */
class LoggedInUserView {
    private String displayName;
    private Customer customer;
    //... other data fields that may be accessible to the UI

    LoggedInUserView(String displayName) {
        this.displayName = displayName;
    }

    LoggedInUserView(Customer customer) {
        this.customer = customer;
    }
    String getDisplayName() {
        return displayName;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}