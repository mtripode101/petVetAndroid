package com.mtripode.pettest1.ui.home;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;

import com.mtripode.pettest1.R;
import com.mtripode.pettest1.entity.Customer;
import com.mtripode.pettest1.utils.SessionUtils;

public class HomeActivity extends AppCompatActivity {

    private EditText editTextTextPersonName;
    private Customer userLoggedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        this.userLoggedIn = SessionUtils.getInstance().getCustomer();
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        String welcome = getString(R.string.home_username) + " "+this.userLoggedIn.getUsername();
        editTextTextPersonName.setText(welcome);

    }
}