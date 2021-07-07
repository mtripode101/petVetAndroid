package com.mtripode.pettest1.ui.addupdatepet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.mtripode.pettest1.R;
import com.mtripode.pettest1.entity.Animal;
import com.mtripode.pettest1.entity.Customer;
import com.mtripode.pettest1.errors.ConnectionError;
import com.mtripode.pettest1.service.AnimalServiceImpl;
import com.mtripode.pettest1.ui.petmenu.PetMenuActivity;
import com.mtripode.pettest1.ui.register.RegisterActivity;
import com.mtripode.pettest1.utils.SessionUtils;
import com.mtripode.pettest1.validators.AnimalValidator;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class AddUpdatePetActivity extends AppCompatActivity {

    private Customer userLoggedIn;
    private Animal animalSelected;

    private TextView editTextAddUpdatePetName;
    private TextView editTextAddUpdatePetSex;
    private TextView editTextAddUpdatePetSpecie;
    private TextView petRegisterTextDateBirthday;
    private DatePickerDialog picker;
    private Date dateBirthday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_update_pet);

        this.userLoggedIn = SessionUtils.getInstance().getCustomer();
        final Button addUpdatePetSave = this.findViewById(R.id.addUpdatePetSave);
        final Button addUpdatePetBack = this.findViewById(R.id.addUpdatePetBack);

        addUpdatePetSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonAddUpdatePetSave(v);
            }
        });

        addUpdatePetBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonAddUpdatePetBack(v);
            }
        });

        this.petRegisterTextDateBirthday = findViewById(R.id.petRegisterTextDateBirthday);
        Button petRegisterGetButton = findViewById(R.id.petRegisterGetButton);
        petRegisterGetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(AddUpdatePetActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                petRegisterTextDateBirthday.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(year, monthOfYear+1, dayOfMonth);

                                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                                dateBirthday = calendar.getTime();

                            }
                        }, year, month, day);
                picker.show();
            }
        });

        this.animalSelected = (Animal) getIntent().getSerializableExtra("animalSelected");
        this.editTextAddUpdatePetName = findViewById(R.id.editTextAddUpdatePetName);
        this.editTextAddUpdatePetSex = findViewById(R.id.editTextAddUpdatePetSex);
        this.editTextAddUpdatePetSpecie = findViewById(R.id.editTextAddUpdatePetSpecie);
        if (this.animalSelected != null){
            this.editTextAddUpdatePetName.setText(this.animalSelected.getName());
            this.editTextAddUpdatePetSex.setText(this.animalSelected.getSex());
            this.editTextAddUpdatePetSpecie.setText(this.animalSelected.getSpecie());
        }
    }

    public void buttonAddUpdatePetSave (View view){
        AnimalServiceImpl animalService = new AnimalServiceImpl();
        try{
            Animal animalToupdate;
            Boolean isNew = false;
            if (this.animalSelected == null){
                animalToupdate = new Animal();
                isNew = true;
            }
            else{
                animalToupdate = animalSelected;
            }

            Customer customer = new Customer();
            customer.setId(userLoggedIn.getId());
            customer.setUsername(userLoggedIn.getUsername());
            customer.setName(userLoggedIn.getName());
            customer.setEmail(userLoggedIn.getEmail());
            customer.setLastName(userLoggedIn.getLastName());
            animalToupdate.setOwner(customer);
            animalToupdate.setSex(this.editTextAddUpdatePetSex.getText().toString());
            animalToupdate.setName(this.editTextAddUpdatePetName.getText().toString());
            animalToupdate.setSpecie(this.editTextAddUpdatePetSpecie.getText().toString());
            animalToupdate.setBirthday(this.dateBirthday);

            AnimalValidator validator = new AnimalValidator();
            HashMap<String, Object> elements = new HashMap<>();
            elements.put("editTextAddUpdatePetSex", editTextAddUpdatePetSex);
            elements.put("editTextAddUpdatePetName", editTextAddUpdatePetName);
            elements.put("editTextAddUpdatePetSpecie", editTextAddUpdatePetSpecie);
            elements.put("petRegisterTextDateBirthday",petRegisterTextDateBirthday);
            elements.put("dateBirthday", dateBirthday);
            Boolean hasError = validator.validate(animalToupdate, elements);
            if (hasError.equals(Boolean.FALSE)){
                if (Boolean.FALSE.equals(isNew)){
                    animalService.updateAnimal(animalToupdate);
                }
                else{
                    animalService.createAnimal(animalToupdate);
                }

                this.back();
            }


        }
        catch (ConnectionError e){

        }
    }

    public void buttonAddUpdatePetBack (View view){
        this.back();
    }

    public void back (){
        Intent intent = new Intent(this, PetMenuActivity.class);
        startActivity(intent);
    }
}