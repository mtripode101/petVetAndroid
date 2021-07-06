package com.mtripode.pettest1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mtripode.pettest1.R;
import com.mtripode.pettest1.entity.Animal;

import java.util.ArrayList;

public class AnimalAdapter extends ArrayAdapter<Animal> {
    public AnimalAdapter(@NonNull Context context, int resource, @NonNull Animal[] objects) {
        super(context, resource, objects);
    }

    public AnimalAdapter(Context context, ArrayList<Animal> animal) {
        super(context, 0, animal);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Animal animal = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_view_pet_menu, parent, false);
        }
        // Lookup view for data population
        TextView animalName = (TextView) convertView.findViewById(R.id.animalName);
        TextView specie = (TextView) convertView.findViewById(R.id.speciePetMenu);
        // Populate the data into the template view using the data object
        animalName.setText(animal.getName());
        specie.setText(animal.getSpecie());
        // Return the completed view to render on screen
        return convertView;
    }
}
