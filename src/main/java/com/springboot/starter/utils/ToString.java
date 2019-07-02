package com.springboot.starter.utils;

import java.io.Serializable;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/*
 * Author: Sopheaktra Yorn
 * Date: 02-07-2019
 */
public class ToString implements Serializable {

    public static final Gson pgson;

    public static final Gson gson;

    static {
        pgson = new GsonBuilder().setPrettyPrinting().create();

        gson = new Gson();
    }
}
