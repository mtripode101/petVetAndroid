package com.mtripode.pettest1.ui.home;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mtripode.pettest1.R;
import com.mtripode.pettest1.entity.Customer;
import com.mtripode.pettest1.entity.Doctor;
import com.mtripode.pettest1.service.DoctorServiceImpl;
import com.mtripode.pettest1.ui.login.LoginActivity;
import com.mtripode.pettest1.ui.petmenu.PetMenuActivity;
import com.mtripode.pettest1.utils.SessionUtils;

import java.util.Set;

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

        final Button buttonAnimals = findViewById(R.id.buttonAnimals);

        buttonAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPet(v);
            }
        });

        Button buttonHomeBack = findViewById(R.id.buttonHomeBack);
        buttonHomeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SessionUtils.getInstance().logout();
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        DoctorServiceImpl doctorService = new DoctorServiceImpl();
        Set<Doctor> doctors = doctorService.getDoctorsByCustomer(this.userLoggedIn);
    }

    public void buttonPet (View view){
        Intent intent = new Intent(this, PetMenuActivity.class);
        startActivity(intent);
    }
}