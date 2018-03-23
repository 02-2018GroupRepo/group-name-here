package hello;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Database {
	
	public static Map<String, Machine> machineDb;
	@PostConstruct
	public static void setMachineDb() {
		Map<String, Machine> machineMap = new HashMap<>();
		//Create snack machines
	    SnackMachine mariettaSnackMachine = new SnackMachine("1", "Marietta", "Company");
	    SnackMachine smyrnaSnackMachine = new SnackMachine("2", "Smyrna", "Company");
	    SnackMachine roswellSnackMachine = new SnackMachine("3", "Roswell", "Company");
	    SnackMachine decaturSnackMachine = new SnackMachine("4", "Decatur", "Company");
	    SnackMachine midtownSnackMachine = new SnackMachine("5", "Midtown", "Company");
	    //Create drink machines
	    DrinkMachine mariettaDrinkMachine = new DrinkMachine("6", "Marietta", "Company");
	    DrinkMachine smyrnaDrinkMachine   = new DrinkMachine("7", "Smyrna", "Company");
	    DrinkMachine roswellDrinkMachine  = new DrinkMachine("8", "Roswell", "Company");
	    DrinkMachine decaturDrinkMachine  = new DrinkMachine("9", "Decatur", "Company");
	    DrinkMachine midtownDrinkMachine  = new DrinkMachine("10", "Midtown", "Company");
	    
	    machineMap.put("1", mariettaSnackMachine);
	    machineMap.put("2", smyrnaSnackMachine);
	    machineMap.put("3", roswellSnackMachine);
	    machineMap.put("4", decaturSnackMachine);
	    machineMap.put("5", midtownSnackMachine);
	    machineMap.put("6", mariettaDrinkMachine);
	    machineMap.put("7", smyrnaDrinkMachine);
	    machineMap.put("8", roswellDrinkMachine);
	    machineMap.put("9", decaturDrinkMachine);
	    machineMap.put("10", midtownDrinkMachine);
		
	    Database.machineDb = machineMap;
	}
	
	
	
	

}
