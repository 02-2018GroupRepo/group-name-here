package hello;

import java.security.AlgorithmConstraints;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Operator {
    private String setPassword = "password123";
    Map<String, ArrayList<Machine>> arrMachine = new HashMap<String, ArrayList<Machine>>();


    public boolean checkPassword(String passwordAttempt){
        if(passwordAttempt.equals(setPassword)) {
            return true;
        }
        return false;
    }

    // Add Method
    public void addLocation(Machine machine) {
        if(arrMachine.containsKey(machine.getLocation())) {
           ArrayList<Machine> m1 =  arrMachine.get(machine.getLocation());
           m1.add(machine);
        } else {
            ArrayList<Machine> newList = new ArrayList<Machine>();
            newList.add(machine);
            arrMachine.put(machine.getLocation(), newList);
        }

    }

    public void printLocation(){

        for (Map.Entry<String, ArrayList<Machine>> arrlist : arrMachine.entrySet()) {
            for (Machine machine:arrlist.getValue()) {
                System.out.println(machine.getLocation());
            }
        }
    }

    // Remove Method

}
