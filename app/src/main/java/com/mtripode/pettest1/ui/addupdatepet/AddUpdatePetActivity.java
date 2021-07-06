package com.mtripode.pettest1.ui.addupdatepet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mtripode.pettest1.R;
import com.mtripode.pettest1.entity.Animal;
import com.mtripode.pettest1.entity.Customer;
import com.mtripode.pettest1.utils.SessionUtils;

public class AddUpdatePetActivity extends AppCompatActivity {

    private Customer userLoggedIn;
    private Animal animalSelected;

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

    }

    public void buttonAddUpdatePetSave (View view){

    }

    public void buttonAddUpdatePetBack (View view){

    }
}