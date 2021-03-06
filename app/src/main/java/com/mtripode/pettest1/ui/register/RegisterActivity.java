package com.mtripode.pettest1.ui.register;

import android.app.DatePickerDialog;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mtripode.pettest1.R;
import com.mtripode.pettest1.entity.Address;
import com.mtripode.pettest1.entity.Animal;
import com.mtripode.pettest1.entity.Customer;
import com.mtripode.pettest1.entity.Doctor;
import com.mtripode.pettest1.errors.ConnectionError;
import com.mtripode.pettest1.errors.ValidatorError;
import com.mtripode.pettest1.helpers.ServiceRestHelper;
import com.mtripode.pettest1.service.CustomerServiceImpl;
import com.mtripode.pettest1.service.RestInterface;
import com.mtripode.pettest1.ui.login.LoginActivity;
import com.mtripode.pettest1.validators.CustomerValidator;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class RegisterActivity extends AppCompatActivity {

    private EditText textViewOwner;
    private EditText editPassword;
    private EditText editConfirmPassword;
    private EditText textViewName;
    private EditText textViewLastName;
    private EditText editEmailAddress;
    private EditText editTextCellPhone;
    private EditText editTextCedula;
    private TextView textViewCustomerRegisterBirthday;
    private CheckBox registerDoctorCheckBox;
    private CustomerValidator customerValidator;
    private DatePickerDialog picker;
    private Date dateBirthday;
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
        this.textViewCustomerRegisterBirthday = findViewById(R.id.textViewCustomerRegisterBirthday);
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

        Button customerRegisterGetDateBirthday = findViewById(R.id.customerRegisterGetDateBirthday);
        customerRegisterGetDateBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(RegisterActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                textViewCustomerRegisterBirthday.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(year, monthOfYear, day);

                                SimpleDateFormat format = new SimpleDateFormat("dd/MMyyyy");
                                dateBirthday = calendar.getTime();

                            }
                        }, year, month, day);
                picker.show();
            }
        });

        Button buttonCustomerRegBack = findViewById(R.id.buttonCustomerRegBack);
        buttonCustomerRegBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
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
        elements.put("editTextCedula", this.editTextCedula);
        elements.put("datebirthday", this.dateBirthday);
        elements.put("textViewCustomerRegisterBirthday", textViewCustomerRegisterBirthday);
        if (this.registerDoctorCheckBox.isChecked()){
            Doctor doctor = new Doctor();
            setCustomerCommonData(doctor);
            doctor.setCedula(this.editTextCedula.getText().toString());
            validateUser(elements, doctor);
        }else{
            Customer customer = new Customer();
            setCustomerCommonData(customer);
            validateUser(elements, customer);
        }

    }

    private void validateUser(HashMap<String, Object> elements, Customer customer) {
        Boolean isValid = true;
        try{
            isValid = this.customerValidator.validate(customer, elements);
            if (Boolean.FALSE.equals(isValid)){
                CustomerServiceImpl createCustomerService = new CustomerServiceImpl();
                try{
                    if (customer instanceof  Doctor){
                        createCustomerService.createDoctorSyn((Doctor) customer);
                    }
                    else if (customer instanceof Customer){
                        createCustomerService.createCustomerSyn(customer);
                    }

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

    private void setCustomerCommonData(Customer customer) {
        customer.setUsername(this.textViewOwner.getText().toString());
        customer.setName(this.textViewName.getText().toString());
        customer.setSex("Male");
        customer.setPasswordConfirm(this.editConfirmPassword.getText().toString());
        customer.setPassword(this.editPassword.getText().toString());
        customer.setLastName(this.textViewLastName.getText().toString());
        customer.setCelphone1(this.editTextCellPhone.getText().toString());
        customer.setEmail(this.editEmailAddress.getText().toString());

        customer.setBirthday(this.dateBirthday);
    }
}