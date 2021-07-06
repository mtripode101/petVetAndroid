package com.mtripode.pettest1.ui.petmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.mtripode.pettest1.R;
import com.mtripode.pettest1.adapters.AnimalAdapter;
import com.mtripode.pettest1.entity.Animal;
import com.mtripode.pettest1.entity.Customer;
import com.mtripode.pettest1.errors.ConnectionError;
import com.mtripode.pettest1.service.AnimalServiceImpl;
import com.mtripode.pettest1.service.CustomerServiceImpl;
import com.mtripode.pettest1.utils.SessionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import static android.widget.AdapterView.*;

public class PetMenuActivity extends AppCompatActivity {

    private Customer userLoggedIn;
    private ListView listAnimalsView;

    private Animal animalSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_menu);

        this.userLoggedIn = SessionUtils.getInstance().getCustomer();
        final Button buttonAddModify = this.findViewById(R.id.buttonAddModifyPet);
        final Button buttonRemovePet = this.findViewById(R.id.buttonRemovePet);

        buttonAddModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonAddModifyPet(v);
            }
        });

        buttonRemovePet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonRemovePet(v);
            }
        });

        listAnimalsView = (ListView) findViewById(R.id.listAnimalsView);

        AnimalServiceImpl animalService = new AnimalServiceImpl();
        Set<Animal> animals = animalService.getAnimalsByOwner(this.userLoggedIn);
        this.userLoggedIn.getAnimals().clear();
        this.userLoggedIn.getAnimals().addAll(animals);

        ArrayList<Animal> arrayOfpet = new ArrayList<Animal>();
        arrayOfpet.addAll(animals);
        AnimalAdapter animalAdapter = new AnimalAdapter(this,arrayOfpet);
        listAnimalsView.setAdapter(animalAdapter);

        listAnimalsView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                animalSelected = (Animal) parent.getAdapter().getItem(position);

            }
        });
    }

    public void buttonAddModifyPet (View view){
        AnimalServiceImpl animalService = new AnimalServiceImpl();
        if (animalSelected != null){
            Toast.makeText(this.getApplicationContext(), "Modifying "+animalSelected.getName(), 2000).show();
            try{
                Animal animalToupdate = animalSelected;
                Customer customer = new Customer();
                customer.setId(userLoggedIn.getId());
                customer.setUsername(userLoggedIn.getUsername());
                customer.setName(userLoggedIn.getName());
                customer.setEmail(userLoggedIn.getEmail());
                customer.setLastName(userLoggedIn.getLastName());
                animalToupdate.setOwner(customer);

                animalService.updateAnimal(animalToupdate);

            }
            catch (ConnectionError e){

            }

        }
        else{
            Toast.makeText(this.getApplicationContext(), "Addinng", 2000).show();

        }

    }

    public void buttonRemovePet (View view){
        if (animalSelected != null){
            Toast.makeText(this.getApplicationContext(), "Remove "+animalSelected.getName(), 2000).show();
        }
        else{
            Toast.makeText(this.getApplicationContext(), "Remove ", 2000).show();
        }


    }
}