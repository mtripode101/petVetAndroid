package com.mtripode.pettest1.ui.petmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mtripode.pettest1.R;
import com.mtripode.pettest1.entity.Animal;
import com.mtripode.pettest1.entity.Customer;
import com.mtripode.pettest1.service.AnimalServiceImpl;
import com.mtripode.pettest1.service.CustomerServiceImpl;
import com.mtripode.pettest1.utils.SessionUtils;

import java.util.Date;
import java.util.Set;

public class PetMenuActivity extends AppCompatActivity {

    private Customer userLoggedIn;

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
    }

    public void buttonAddModifyPet (View view){
        Toast.makeText(this.getApplicationContext(), "AddModify", 2000).show();
        AnimalServiceImpl animalService = new AnimalServiceImpl();
        Animal animalTest = new Animal();
        animalTest.setSpecie("Test1");
        animalTest.setName("TestName1");
        animalTest.setSex("Male");
        animalTest.setBirthday(new Date());
        animalTest.setOwner(this.userLoggedIn);
        Animal newAnimal = animalService.createAnimal(animalTest);

        this.userLoggedIn.getAnimals().add(newAnimal);
    }

    public void buttonRemovePet (View view){
        Toast.makeText(this.getApplicationContext(), "Remove", 2000).show();
        AnimalServiceImpl animalService = new AnimalServiceImpl();
        Set<Animal> animals = animalService.getAnimalsByOwner(this.userLoggedIn);
        this.userLoggedIn.getAnimals().clear();
        this.userLoggedIn.getAnimals().addAll(animals);
    }
}