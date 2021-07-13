package com.mtripode.pettest1.utils;

import com.mtripode.pettest1.helpers.ServiceRestHelper;
import com.mtripode.pettest1.service.RestInterface;

import java.lang.reflect.Type;

public class HttpUtils {

    public static RestInterface getRestInterface (){
        return ServiceRestHelper.getInstance().create();
    }

    public static RestInterface getRestInterfaceWithTypeAdapter (Type type, Object typeAdapter){
        return ServiceRestHelper.getInstance().createWithTypeAdapter(type,typeAdapter);
    }
}
