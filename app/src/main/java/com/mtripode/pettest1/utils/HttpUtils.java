package com.mtripode.pettest1.utils;

import com.mtripode.pettest1.helpers.ServiceRestHelper;
import com.mtripode.pettest1.service.RestInterface;

public class HttpUtils {

    public static RestInterface getRestInterface (){
        return ServiceRestHelper.getInstance().create();
    }
}
