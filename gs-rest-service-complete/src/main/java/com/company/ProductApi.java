package com.company;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.company.database.domain.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ProductApi {

    public static ArrayList<Product> retrieveProductList() {

        try {
			ArrayList<Product> productsList = new ArrayList<>();
			InputStream is = new URL("https://arcane-sands-23198.herokuapp.com/").openStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			JSONParser parser = new JSONParser();
			String json = rd.readLine();
			Object obj = parser.parse(json);
			JSONObject jsonObj = (JSONObject) obj;
			Gson gson = new GsonBuilder().create(); 
		    Product[] arr  = gson.fromJson(jsonObj.get("data").toString(), Product[].class);
		    for (Product product : arr) {
		    		productsList.add(product);
		    }
		    return productsList;
			rd.close();
		} catch (Exception e) {
			System.out.println(e);
		}

    }

}