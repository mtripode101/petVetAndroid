package com.mtripode.pettest1.ui.home.doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mtripode.pettest1.R;
import com.mtripode.pettest1.entity.Customer;
import com.mtripode.pettest1.ui.home.HomeActivity;
import com.mtripode.pettest1.ui.login.LoginActivity;
import com.mtripode.pettest1.utils.SessionUtils;

public class HomeDoctorActivity extends AppCompatActivity {

    private Customer userLoggedIn;
    private EditText editTextHomeDoctorUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_doctor);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        this.userLoggedIn = SessionUtils.getInstance().getCustomer();

        this.editTextHomeDoctorUser = findViewById(R.id.editTextHomeDoctorUser);
        String welcome = getString(R.string.home_username) + " "+this.userLoggedIn.getUsername();
        this.editTextHomeDoctorUser.setText(welcome);

        Button buttonHomeDoctorBack = findViewById(R.id.buttonHomeDoctorBack);
        buttonHomeDoctorBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SessionUtils.getInstance().logout();
                Intent intent = new Intent(HomeDoctorActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}