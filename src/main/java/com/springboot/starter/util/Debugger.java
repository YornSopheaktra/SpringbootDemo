package com.springboot.starter.util;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Debugger {

	public static void debugObject(String titleTest,Object ob) {
		Gson gson = new GsonBuilder().serializeNulls().create();
		String message = "<==========="+titleTest+":==============>\n"+gson.toJson(ob);
		System.out.println(message);
	}
}
