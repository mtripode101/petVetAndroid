package com.mtripode.pettest1.ui.customerDoctorsMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.mtripode.pettest1.R;
import com.mtripode.pettest1.adapters.AnimalAdapter;
import com.mtripode.pettest1.adapters.DoctorAdapter;
import com.mtripode.pettest1.entity.Animal;
import com.mtripode.pettest1.entity.Customer;
import com.mtripode.pettest1.entity.Doctor;
import com.mtripode.pettest1.errors.ConnectionError;
import com.mtripode.pettest1.service.AnimalServiceImpl;
import com.mtripode.pettest1.service.DoctorServiceImpl;
import com.mtripode.pettest1.ui.addupdatepet.AddUpdatePetActivity;
import com.mtripode.pettest1.ui.home.HomeActivity;
import com.mtripode.pettest1.ui.petmenu.PetMenuActivity;
import com.mtripode.pettest1.utils.SessionUtils;

import java.util.ArrayList;
import java.util.Set;

public class CustomerDoctorsActivity extends AppCompatActivity {

    private Customer userLoggedIn;
    private ListView listDoctorsView;

    private Doctor doctorSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_doctors);

        this.userLoggedIn = SessionUtils.getInstance().getCustomer();

        final Button buttonDocAddUpdate = this.findViewById(R.id.buttonDocAddUpdate);
        final Button buttonDocRemove = this.findViewById(R.id.buttonDocRemove);

        buttonDocAddUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonAddModifyDoctor(v);
            }
        });

        buttonDocRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonRemoveDoctor(v);
            }
        });

        listDoctorsView = (ListView) findViewById(R.id.listDoctorsView);

        DoctorServiceImpl doctorService = new DoctorServiceImpl();
        Set<Doctor> doctors = doctorService.getDoctorsByCustomer(this.userLoggedIn);
        this.userLoggedIn.getDoctors().clear();
        this.userLoggedIn.getDoctors().addAll(doctors);

        ArrayList<Doctor> arrayOfdoc = new ArrayList<Doctor>();
        arrayOfdoc.addAll(doctors);
        DoctorAdapter doctorAdapter = new DoctorAdapter(this,arrayOfdoc);
        listDoctorsView.setAdapter(doctorAdapter);

        listDoctorsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                doctorSelected = (Doctor) parent.getAdapter().getItem(position);

            }
        });

        Button buttonDocBack = findViewById(R.id.buttonDocBack);
        buttonDocBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CustomerDoctorsActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    public void buttonAddModifyDoctor (View view){

    }

    public void buttonRemoveDoctor (View view){
        if (doctorSelected != null){
            Toast.makeText(this.getApplicationContext(), "Remove "+doctorSelected.getUsername(), 2000).show();
        }
        else{
            Toast.makeText(this.getApplicationContext(), "Remove ", 2000).show();
        }


    }
}