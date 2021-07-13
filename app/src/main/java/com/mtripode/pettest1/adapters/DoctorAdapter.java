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
import com.mtripode.pettest1.entity.Doctor;

import java.util.ArrayList;

public class DoctorAdapter extends ArrayAdapter<Doctor> {
    public DoctorAdapter(@NonNull Context context, int resource, @NonNull Doctor[] objects) {
        super(context, resource, objects);
    }

    public DoctorAdapter(Context context, ArrayList<Doctor> doctors) {
        super(context, 0, doctors);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Doctor doctor = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_view_doctors_menu, parent, false);
        }
        // Lookup view for data population
        TextView doctorUsername = (TextView) convertView.findViewById(R.id.doctorUsername);
        TextView doctorEmail = (TextView) convertView.findViewById(R.id.doctorEmail);
        // Populate the data into the template view using the data object
        doctorUsername.setText(doctor.getUsername());
        doctorEmail.setText(doctor.getEmail());
        // Return the completed view to render on screen
        return convertView;
    }
}
