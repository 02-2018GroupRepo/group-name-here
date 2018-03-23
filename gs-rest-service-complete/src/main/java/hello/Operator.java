package hello;

import java.util.*;

public class Operator {

    private String setPassword = "password123";
    Map<String, ArrayList<Machine>> arrMachine = new HashMap<String, ArrayList<Machine>>();

    // Give Authentication to Operator
    public boolean checkPassword(String passwordAttempt) {
        if (passwordAttempt.equals(setPassword)) {
            return true;
        }
        return false;
    }

    // The Add Method
    public void addLocation(Machine machine) {

        // Checks if machine location pre-exist in the defined HashMap
        if (arrMachine.containsKey(machine.getLocation())) {
            ArrayList<Machine> m1 = arrMachine.get(machine.getLocation());
            m1.add(machine);
        } else {
            ArrayList<Machine> newList = new ArrayList<Machine>();
            newList.add(machine);
            arrMachine.put(machine.getLocation(), newList);
        }

    }

    // Use to test the defined HashMap
    public void printLocation() {

        for (Map.Entry<String, ArrayList<Machine>> arrlist : arrMachine.entrySet()) {
            System.out.println(arrlist.getKey());
            for (Machine machine : arrlist.getValue()) {
                System.out.println("\t[ID: " + machine.id + "]");
            }
        }
    }

    // The Remove Method
    public Machine removeMachine(String id) {

        // Loop through the HashMap of ArrayList
        for (Iterator<Map.Entry<String, ArrayList<Machine>>> it = arrMachine.entrySet().iterator(); it.hasNext(); ) {

            // Use "it" as a Rover to point/fetch at the next entry in HashMap
            Map.Entry<String, ArrayList<Machine>> entry = it.next();


            // Loop through the current Entry ArrayList && Use "jt" as a Rover to point/fetch at each machine in ArrayList
            for (Iterator<Machine> jt = entry.getValue().iterator(); jt.hasNext(); ) {
                Machine aMachine = jt.next();
                Machine tempMachine;  // Variable to store machine when being removed

                // Check if given "id" matches the machine being iterated
                if (aMachine.getId().equalsIgnoreCase(id)) {
                    tempMachine = aMachine;

                    // Check if the location has more than one machine
                    if (entry.getValue().size() > 1) {
                        jt.remove();
                    } else {
                        jt.remove();
                        arrMachine.remove(tempMachine.getLocation());
                    }

                    return tempMachine;

                }
            }
        }

        // Nothing found matching the given "id"
        return null;
    }


    // Print 'each machine' Total Amount
    public String eachMachineCount() {
        String amount = "";

        //Print out each machine
        for (Map.Entry<String, ArrayList<Machine>> entryMachines : arrMachine.entrySet()) {
            amount += entryMachines.getKey() + "\n";
            for (Machine machine : entryMachines.getValue()) {
                amount += "\t[ID: " + machine.getId() + " | Money: " + machine.getTotalAmountOfMoney() + "] ";
            }
            amount += "\n";
        }
        return amount;
    }


    // Print 'all machines' Total Amount
    public String allMachineCount() {
        Double totalAmount = 0.0;

        // Loop through Map
        for (Map.Entry<String, ArrayList<Machine>> entries : arrMachine.entrySet()){
            // Loop through ArrayList
            for (Machine machine : entries.getValue()) {
                totalAmount += machine.getTotalAmountOfMoney();
            }
        }
        return "Total Amount of All Machines: " + "$" + totalAmount;
    }


    // Print 'all machines' Total Amount by 'location'
    public String allMachineCountByLocation(String location) {
        Double totalLocationAmount = 0.0;


        if (arrMachine.containsKey(location)) {
            // Loop through this location Array
            for (Machine machine:arrMachine.get(location)) {
                totalLocationAmount += machine.getTotalAmountOfMoney();
            }
        } else {
            return "error";
        }
        return "Total amount in " + location + " " + totalLocationAmount;
    }



    public void operatorUI(){
        int userInput;
        Random rand = new Random();

        do {
            printOperatorOptions();

            System.out.println("\nEnter an operator option:");
           userInput = Buffer.intBufferIO();

           switch(userInput){
               case 1:
                   System.out.println("Create new machine");
                   int randID = rand.nextInt(100);
                   System.out.println("Add a location");
                   String location = Buffer.stringBufferIO();
                   SnackMachine newMachine = new SnackMachine("ID_"+randID, location, "Home Depot");
                   addLocation(newMachine);
                   break;
               case 2:
                   printLocation();
                   System.out.println("Which machine to remove");
                   String id = Buffer.stringBufferIO();
                   removeMachine(id);
                   break;
               case 3:
                   System.out.println(eachMachineCount());
                   break;
               case 4:
                   printLocation();
                   System.out.println("Enter location to return total amount of money");
                   System.out.println(allMachineCountByLocation(Buffer.stringBufferIO()));
                   break;
               case 5:
                   System.out.println(allMachineCount());
                   break;
               case 6:
                   printLocation();
                   break;
               case 7:
                   break;
                   default:
                       System.out.println("Sorry incorrect input");
                       break;
           }
        }
        while(userInput != 7);

    }

    public void printOperatorOptions(){

        System.out.println();
        System.out.println("1: Add a machine to a location");
        System.out.println("2: Remove a machine from a location");
        System.out.println("3: Show each machine total amount of money");
        System.out.println("4: Show each location total amount of money");
        System.out.println("5: Show amount of money across of all machines");
        System.out.println("6: Print machines");
        System.out.println("7: Done");
    }



}