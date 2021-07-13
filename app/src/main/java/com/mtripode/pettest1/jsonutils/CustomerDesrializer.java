package com.mtripode.pettest1.jsonutils;

import android.annotation.SuppressLint;
import android.util.ArraySet;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.mtripode.pettest1.entity.Customer;
import com.mtripode.pettest1.entity.Doctor;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerDesrializer implements JsonDeserializer<Customer> {


    @Override
    public Customer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final JsonObject jsonObject = json.getAsJsonObject();

        if (jsonObject.get("cedula") != null){
            String cedula = jsonObject.get("cedula").getAsString();
            Doctor doctor = this.getDoctor();
            this.setCommonValues(jsonObject, doctor);
            doctor.setCedula(cedula);
            return doctor;
        }
        else{
            Customer customer = this.getCustomer();
            this.setCommonValues(jsonObject, customer);
            return customer;
        }

    }

    private Customer getCustomer (){
        return new Customer();
    }

    private Doctor getDoctor (){
        return new Doctor();
    }

    @SuppressLint("NewApi")
    private void setCommonValues (JsonObject jsonObject, Customer customer){
        if (!this.isNullValue( jsonObject.get("id"))){
            customer.setId( jsonObject.get("id").getAsLong());
        }


        Date birthDate = null;
        try {
            String dateStr = jsonObject.get("birthday").getAsString();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            birthDate = sdf.parse(dateStr);
        } catch (Exception e) {
            birthDate = new Date();
        }

        customer.setBirthday(birthDate);
        if (!this.isNullValue(jsonObject.get("lastName"))){
            customer.setLastName(jsonObject.get("lastName").getAsString());
        }

        if (!this.isNullValue((jsonObject.get("email")))){
            customer.setEmail(jsonObject.get("email").getAsString());
        }

        if (!this.isNullValue(jsonObject.get("username"))){
            customer.setUsername(jsonObject.get("username").getAsString());
        }

        if (!this.isNullValue(jsonObject.get("name"))){
            customer.setName(jsonObject.get("name").getAsString());
        }

        if (!this.isNullValue(jsonObject.get("password"))){
            customer.setPassword(jsonObject.get("password").getAsString());
        }

        if (!this.isNullValue(jsonObject.get("celphone1"))){
            customer.setCelphone1(jsonObject.get("celphone1").getAsString());
        }

        if (!this.isNullValue(jsonObject.get("celphone2"))){
            customer.setCelphone2(jsonObject.get("celphone2").getAsString());
        }

        if (!this.isNullValue(jsonObject.get("celphone3"))){
            customer.setCelphone3(jsonObject.get("celphone3").getAsString());
        }

        if (!this.isNullValue(jsonObject.get("sex"))){
            customer.setSex(jsonObject.get("sex").getAsString());
        }

        if (!this.isNullValue(jsonObject.get("enable"))){
            customer.setEnable(jsonObject.get("enable").getAsBoolean());
        }

        customer.setUserClose(new Date());
        customer.setUserCreation(new Date());
        customer.setAnimals(new ArraySet<>());
        customer.setDoctors(new ArraySet<>());
        customer.setAddresses(new ArraySet<>());
        customer.setHospital(new ArraySet<>());
    }

    private boolean isNullValue (Object obj){
        return obj.toString().equals("null");
    }
}
