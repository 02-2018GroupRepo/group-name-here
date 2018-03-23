package hello;

import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

 

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/admin")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping("/api/machine")
    //public void itemPurchased(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	public void itemPurchased(HttpServletRequest request, HttpServletResponse response, @RequestParam("machineId") String machineId, @RequestParam("productId") String productId, @RequestParam("quarters") String quarters, @RequestParam("nickels") String nickels, @RequestParam("dimes") String dimes, @RequestParam("productName") String productName) throws Exception {
    	 response.addHeader("Access-Control-Allow-Origin", "*");
    	 response.addHeader("Access-Control-Allow-Methods", "GET, POST, PATCH, PUT, DELETE, OPTIONS");
    	 response.addHeader("Access-Control-Allow-Headers", "Origin, Content-Type, X-Auth-Token");
    	 response.setContentType("application/json");
    
    	 double total;
    	 Gson gson = new Gson();

    	 double quartersValue = Double.valueOf(quarters) * .25;
    	 double dimesValue = Double.valueOf(dimes) * .1;
    	 double nickelsValue = Double.valueOf(nickels) * .05;
    	 System.out.println(Database.machineDb);
		
    		Machine myMachine = Database.machineDb.get(machineId);
    		
    		for (int i=0; i < Integer.valueOf(nickels); i++) {
       		 Coins nickel = new Coins(0.05);
       		 myMachine.coinManager.addCoin(nickel);
       	 }
    		
    		for (int i=0; i < Integer.valueOf(dimes); i++) {
          		 Coins dime = new Coins(0.10);
          		 myMachine.coinManager.addCoin(dime);
          	 }
    		
    		for (int i=0; i < Integer.valueOf(quarters); i++) {
          		 Coins quarter = new Coins(0.25);
          		 myMachine.coinManager.addCoin(quarter);
          	 }
    		
    		
    		if (myMachine instanceof DrinkMachine) {
    			if (((DrinkMachine) myMachine).validateInventory(productId) > 0) {
    				if (myMachine.coinManager.totalAmount() < 2) {
    					System.out.println("User did not enter enough coins");
    					response.getWriter().write(gson.toJson(new MachineDataJson(0, false, false)));
    				} else {
    					((DrinkMachine) myMachine).dispense(productName, 1);
    					double change = myMachine.coinManager.totalAmount() - 2;
    					String stringChange = String.format("%.2f", change);
    					System.out.printf("Drink Machine in %s sold %s.", myMachine.getLocation(), productName);
    					System.out.println(((DrinkMachine) Database.machineDb.get(machineId)).getAmountOfBottledDrPepper());
    					response.getWriter().write(gson.toJson(new MachineDataJson(Double.valueOf(change), false, true)));
    				}
    			} else {
    				response.getWriter().write(gson.toJson(new MachineDataJson(0, false, true)));
    			}
    		} else {
    			if (((SnackMachine) myMachine).validateInventory(productId) > 0) {
    				if (myMachine.coinManager.totalAmount() < 2) {
    					System.out.println("User did not enter enough coins");
    					response.getWriter().write(gson.toJson(new MachineDataJson(0, false, false)));
    				} else {
    					double change = myMachine.coinManager.totalAmount() - 2;
    					((SnackMachine) myMachine).dispense(productName, 1);
    					String stringChange = String.format("%.2f", change);
    					System.out.printf("Snack Machine in %s sold a %s.", myMachine.getLocation(), productName);
    					response.getWriter().write(gson.toJson(new MachineDataJson(Double.valueOf(change), false, true)));
    				}
    			} else {
    				System.out.println(productName + " is out of stock in " + myMachine.getLocation());
    				response.getWriter().write(gson.toJson(new MachineDataJson(0, true, false)));
    			}
    		}
    }
}
    

