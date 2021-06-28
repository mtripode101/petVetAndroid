package com.mtripode.pettest1.helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mtripode.pettest1.service.RestInterface;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceRestHelper {

    private static final String BASEPOINT = "http://192.168.0.15:8080/petVet/";

    private static OkHttpClient httpClient = new OkHttpClient();
    private static ServiceRestHelper instance = new ServiceRestHelper();
    private RestInterface service;

    public static ServiceRestHelper getInstance() {
        return instance;
    }

    public Retrofit createAdapter() {

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create();

        httpClient = new OkHttpClient().newBuilder().build();
        httpClient.newBuilder().connectTimeout(60, TimeUnit.SECONDS);
        httpClient.newBuilder().readTimeout(60, TimeUnit.SECONDS);
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new Retrofit.Builder()
                .baseUrl(BASEPOINT)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public RestInterface create (){
        return ServiceRestHelper.getInstance().createAdapter().create(RestInterface.class);
    }




}
