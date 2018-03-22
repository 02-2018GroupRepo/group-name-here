package hello

class OperatorSpec extends spock.lang.Specification {

    def "Operator needs security code for authorization to perform action"() {

        given: "Password is set"
        Operator myOP = new Operator();

        when: "Correct password is entered"
        boolean access = myOP.checkPassword("password123");

        then: "Gains access for actions"
        if (access) {
            println("You have access.  Please proceed ");
        } else {
            println("Please put in a valid access credentials");
        }
    }

    def "Operator wants to add machine to location"() {

        given: "Op has access"
        Operator ChristianHill = new Operator();

        and: "a machine"

        Machine sampleMachineA = new Machine();
        sampleMachineA.setLocation("Harvard");
        ChristianHill.addLocation(sampleMachineA);

        Machine sampleMachineB = new Machine();
        sampleMachineB.setLocation("Harvard");
        ChristianHill.addLocation(sampleMachineB);

        Machine sampleMachineC = new Machine();
        sampleMachineC.setLocation("Harvard");
        ChristianHill.addLocation(sampleMachineC);

        Machine sampleMachineD = new Machine();
        sampleMachineD.setLocation("Clemson");
        ChristianHill.addLocation(sampleMachineD);

        Machine sampleMachineE = new Machine();
        sampleMachineE.setLocation("Georgia State");
        ChristianHill.addLocation(sampleMachineE);

        when: "Machine location is selected"

        then: " Add the machine to location list and set the machine's location"

        ChristianHill.arrMachine == ["Harvard": [sampleMachineA, sampleMachineB, sampleMachineC],
                                     "Clemson": [sampleMachineD], "Georgia State": [sampleMachineE]]

    }

    def "Operator wants to remove a machine from the list"() {

        given: "Op has access"

        Operator ChristianHill = new Operator();
        and: "that there's a machine in the list"

        Machine sampleMachineA = new Machine();
        sampleMachineA.setLocation("Harvard");
        ChristianHill.addLocation(sampleMachineA);

        Machine sampleMachineB = new Machine();
        sampleMachineB.setLocation("Harvard");
        ChristianHill.addLocation(sampleMachineB);

        Machine sampleMachineC = new Machine();
        sampleMachineC.setLocation("Harvard");
        ChristianHill.addLocation(sampleMachineC);

        Machine sampleMachineD = new Machine();
        sampleMachineD.setLocation("Clemson");
        ChristianHill.addLocation(sampleMachineD);

        Machine sampleMachineE = new Machine();
        sampleMachineE.setLocation("Georgia State");
        ChristianHill.addLocation(sampleMachineE);

        and: "a machine id"
        sampleMachineA.setId("smA");
        sampleMachineB.setId("smB");
        sampleMachineC.setId("smC");
        sampleMachineD.setId("smD");
        sampleMachineE.setId("smE");


        when: "Remove machine from location list"
        ChristianHill.removeMachine(sampleMachineA.getId());

        then: "return the machine"
        ChristianHill.arrMachine == ["Harvard":[sampleMachineB, sampleMachineC],
                                     "Clemson":[sampleMachineD], "Georgia State": [sampleMachineE]]

    }


    def "Op checks amount of money in each machine"() {

        given: "Op having access"

        Operator ChristianHill = new Operator();

        Machine sampleMachineA = new Machine();
        sampleMachineA.setLocation("Harvard");
        ChristianHill.addLocation(sampleMachineA);

        Machine sampleMachineB = new Machine();
        sampleMachineB.setLocation("Harvard");
        ChristianHill.addLocation(sampleMachineB);

        Machine sampleMachineC = new Machine();
        sampleMachineC.setLocation("Harvard");
        ChristianHill.addLocation(sampleMachineC);

        Machine sampleMachineD = new Machine();
        sampleMachineD.setLocation("Clemson");
        ChristianHill.addLocation(sampleMachineD);

        Machine sampleMachineE = new Machine();
        sampleMachineE.setLocation("Georgia State");
        ChristianHill.addLocation(sampleMachineE);

        sampleMachineA.setId("smA");
        sampleMachineB.setId("smB");
        sampleMachineC.setId("smC");
        sampleMachineD.setId("smD");
        sampleMachineE.setId("smE");

        sampleMachineA.setMoney(1);
        sampleMachineB.setMoney(2);
        sampleMachineC.setMoney(3);
        sampleMachineD.setMoney(4);
        sampleMachineE.setMoney(5);
        when: "'Each machine' option is chosen"

        String amount = ChristianHill.eachMachineCount();
        then: "Print each machine 'Total Amount'"

        amount == "Georgia State\n" +
                "\t[ID: smE | Money: 5.0] \n" +
                "Harvard\n" +
                "\t[ID: smA | Money: 1.0] \t[ID: smB | Money: 2.0] \t[ID: smC | Money: 3.0] \n" +
                "Clemson\n" +
                "\t[ID: smD | Money: 4.0]"
    }



    def "Op checks amount of money in all machine"() {

        given: "Op having access"

        Operator ChristianHill = new Operator();

        Machine sampleMachineA = new Machine();
        sampleMachineA.setLocation("Harvard");
        ChristianHill.addLocation(sampleMachineA);

        Machine sampleMachineB = new Machine();
        sampleMachineB.setLocation("Harvard");
        ChristianHill.addLocation(sampleMachineB);

        Machine sampleMachineC = new Machine();
        sampleMachineC.setLocation("Harvard");
        ChristianHill.addLocation(sampleMachineC);

        Machine sampleMachineD = new Machine();
        sampleMachineD.setLocation("Clemson");
        ChristianHill.addLocation(sampleMachineD);

        Machine sampleMachineE = new Machine();
        sampleMachineE.setLocation("Georgia State");
        ChristianHill.addLocation(sampleMachineE);

        sampleMachineA.setId("smA");
        sampleMachineB.setId("smB");
        sampleMachineC.setId("smC");
        sampleMachineD.setId("smD");
        sampleMachineE.setId("smE");

        sampleMachineA.setMoney(1);
        sampleMachineB.setMoney(2);
        sampleMachineC.setMoney(3);
        sampleMachineD.setMoney(4);
        sampleMachineE.setMoney(5);

        when: "'All Machine' option is chosen"

        String amount = ChristianHill.allMachineCount();

        then: "Print All machines total amount combined"
        amount == "Total Amount of All Machines: \$" + "15.0"
    }






    def "Op checks the amount of money in all machines by location"(){

        given: "Op has access"

        Operator ChristianHill = new Operator();

        Machine sampleMachineA = new Machine();
        sampleMachineA.setLocation("Harvard");
        ChristianHill.addLocation(sampleMachineA);

        Machine sampleMachineB = new Machine();
        sampleMachineB.setLocation("Harvard");
        ChristianHill.addLocation(sampleMachineB);

        Machine sampleMachineC = new Machine();
        sampleMachineC.setLocation("Harvard");
        ChristianHill.addLocation(sampleMachineC);

        Machine sampleMachineD = new Machine();
        sampleMachineD.setLocation("Clemson");
        ChristianHill.addLocation(sampleMachineD);

        Machine sampleMachineE = new Machine();
        sampleMachineE.setLocation("Georgia State");
        ChristianHill.addLocation(sampleMachineE);

        sampleMachineA.setId("smA");
        sampleMachineB.setId("smB");
        sampleMachineC.setId("smC");
        sampleMachineD.setId("smD");
        sampleMachineE.setId("smE");

        sampleMachineA.setMoney(1);
        sampleMachineB.setMoney(2);
        sampleMachineC.setMoney(3);
        sampleMachineD.setMoney(4);
        sampleMachineE.setMoney(5);

        and: "a specified location"

        when: "'LocationAmount' option is chosen"

        String amount = ChristianHill.allMachineCountByLocation("Harvard");

        then: "print totalAmount of All machines in a location"
        amount == "Total amount in Harvard " + "6.0"
    }




}