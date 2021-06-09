package com.mtripode.pettest1.ui.register;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.mtripode.pettest1.R;
import com.mtripode.pettest1.entity.Customer;
import com.mtripode.pettest1.errors.ConnectionError;
import com.mtripode.pettest1.errors.ValidatorError;
import com.mtripode.pettest1.helpers.ServiceRestHelper;
import com.mtripode.pettest1.service.CustomerServiceImpl;
import com.mtripode.pettest1.service.RestInterface;
import com.mtripode.pettest1.ui.login.LoginActivity;
import com.mtripode.pettest1.validators.CustomerValidator;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    private EditText textViewOwner;
    private EditText editPassword;
    private EditText editConfirmPassword;
    private EditText textViewName;
    private EditText textViewLastName;
    private EditText editEmailAddress;
    private EditText editTextCellPhone;
    private EditText editTextCedula;
    private CheckBox registerDoctorCheckBox;

    private Customer customer;

    private CustomerValidator customerValidator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final Button registerButton = findViewById(R.id.registerButton);

        this.textViewOwner = findViewById(R.id.textViewOwner);
        this.editConfirmPassword = findViewById(R.id.editConfirmPassword);
        this.editPassword = findViewById(R.id.editPassword);
        this.textViewName = findViewById(R.id.textViewOwner);
        this.textViewLastName = findViewById(R.id.textViewLastName);
        this.editEmailAddress = findViewById(R.id.editEmailAddress);
        this.editTextCellPhone = findViewById(R.id.editTextCellPhone);
        this.editTextCedula = findViewById(R.id.editTextCedula);
        this.editTextCedula.setVisibility(View.INVISIBLE);
        this.registerDoctorCheckBox = findViewById(R.id.registerDoctorCheckBox);
        this.customerValidator = new CustomerValidator();

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               buttonRegister(v);
            }
        });

        this.registerDoctorCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

           @Override
           public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                if (Boolean.TRUE.equals(isChecked)){
                    editTextCedula.setVisibility(View.VISIBLE);
                    textViewOwner.setHint(R.string.vet_register);
                }
                else{
                    editTextCedula.setVisibility(View.INVISIBLE);
                    textViewOwner.setHint(R.string.owner_register);
                }
           }
       }
        );
    }

    public void buttonRegister (View view){
        HashMap<String, Object> elements = new HashMap<String, Object>();
        elements.put("textViewOwner", this.textViewOwner);
        elements.put("editConfirmPassword",this.editConfirmPassword);
        elements.put("editPassword",this.editPassword);
        elements.put("textViewName",this.textViewName);
        elements.put("textViewLastName",this.textViewLastName);
        elements.put("editEmailAddress",this.editEmailAddress);
        elements.put("editTextCellPhone",this.editTextCellPhone);

        this.customer = new Customer();
        this.customer.setUsername(this.textViewOwner.getText().toString());
        this.customer.setName(this.textViewName.getText().toString());
        this.customer.setSex("Male");
        this.customer.setPasswordConfirm(this.editConfirmPassword.getText().toString());
        this.customer.setPassword(this.editPassword.getText().toString());
        this.customer.setLastName(this.textViewLastName.getText().toString());
        this.customer.setCelphone1(this.editTextCellPhone.getText().toString());

        this.customer.setEmail(this.editEmailAddress.getText().toString());
        Boolean isValid = true;
        try{
            isValid = this.customerValidator.validate(customer, elements);
            if (Boolean.FALSE.equals(isValid)){
                CustomerServiceImpl createCustomerService = new CustomerServiceImpl();
                try{
                    createCustomerService.createCustomerSyn(this.customer);
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                }
                catch (ConnectionError e){
                    Toast.makeText(this, e.getMessage(), 2000).show();
                }


            }
            else{
                if (elements.containsKey("connectionError")){
                    String mjs = (String) elements.get("connectionError");
                    Toast.makeText(this,mjs, 2000).show();
                }
            }
        }
        catch (ValidatorError e){
            Toast.makeText(this, e.getMessage(), 2000).show();
        }


    }
}