package hello

import spock.lang.Specification


class OperatorSpec extends Specification {
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

    def "Operator wants to add SnackMachine to location"() {

        given: "Op has access"
        Operator ChristianHill = new Operator();

        and: "a SnackMachine"

        SnackMachine sampleSnackMachineA = new SnackMachine();
        sampleSnackMachineA.setLocation("Harvard");
        ChristianHill.addLocation(sampleSnackMachineA);

        SnackMachine sampleSnackMachineB = new SnackMachine();
        sampleSnackMachineB.setLocation("Harvard");
        ChristianHill.addLocation(sampleSnackMachineB);

        SnackMachine sampleSnackMachineC = new SnackMachine();
        sampleSnackMachineC.setLocation("Harvard");
        ChristianHill.addLocation(sampleSnackMachineC);

        SnackMachine sampleSnackMachineD = new SnackMachine();
        sampleSnackMachineD.setLocation("Clemson");
        ChristianHill.addLocation(sampleSnackMachineD);

        SnackMachine sampleSnackMachineE = new SnackMachine();
        sampleSnackMachineE.setLocation("Georgia State");
        ChristianHill.addLocation(sampleSnackMachineE);

        when: "SnackMachine location is selected"

        then: " Add the SnackMachine to location list and set the SnackMachine's location"

        ChristianHill.arrSnackMachine == ["Harvard": [sampleSnackMachineA, sampleSnackMachineB, sampleSnackMachineC],
                                     "Clemson": [sampleSnackMachineD], "Georgia State": [sampleSnackMachineE]]

    }

    def "Operator wants to remove a SnackMachine from the list"() {

        given: "Op has access"

        Operator ChristianHill = new Operator();
        and: "that there's a SnackMachine in the list"

        SnackMachine sampleSnackMachineA = new SnackMachine();
        sampleSnackMachineA.setLocation("Harvard");
        ChristianHill.addLocation(sampleSnackMachineA);

        SnackMachine sampleSnackMachineB = new SnackMachine();
        sampleSnackMachineB.setLocation("Harvard");
        ChristianHill.addLocation(sampleSnackMachineB);

        SnackMachine sampleSnackMachineC = new SnackMachine();
        sampleSnackMachineC.setLocation("Harvard");
        ChristianHill.addLocation(sampleSnackMachineC);

        SnackMachine sampleSnackMachineD = new SnackMachine();
        sampleSnackMachineD.setLocation("Clemson");
        ChristianHill.addLocation(sampleSnackMachineD);

        SnackMachine sampleSnackMachineE = new SnackMachine();
        sampleSnackMachineE.setLocation("Georgia State");
        ChristianHill.addLocation(sampleSnackMachineE);

        and: "a SnackMachine id"
        sampleSnackMachineA.setId("smA");
        sampleSnackMachineB.setId("smB");
        sampleSnackMachineC.setId("smC");
        sampleSnackMachineD.setId("smD");
        sampleSnackMachineE.setId("smE");


        when: "Remove SnackMachine from location list"
        ChristianHill.removeSnackMachine(sampleSnackMachineA.getId());

        then: "return the SnackMachine"
        ChristianHill.arrSnackMachine == ["Harvard":[sampleSnackMachineB, sampleSnackMachineC],
                                     "Clemson":[sampleSnackMachineD], "Georgia State": [sampleSnackMachineE]]

    }


    def "Op checks amount of money in each SnackMachine"() {

        given: "Op having access"

        Operator ChristianHill = new Operator();

        SnackMachine sampleSnackMachineA = new SnackMachine();
        sampleSnackMachineA.setLocation("Harvard");
        ChristianHill.addLocation(sampleSnackMachineA);

        SnackMachine sampleSnackMachineB = new SnackMachine();
        sampleSnackMachineB.setLocation("Harvard");
        ChristianHill.addLocation(sampleSnackMachineB);

        SnackMachine sampleSnackMachineC = new SnackMachine();
        sampleSnackMachineC.setLocation("Harvard");
        ChristianHill.addLocation(sampleSnackMachineC);

        SnackMachine sampleSnackMachineD = new SnackMachine();
        sampleSnackMachineD.setLocation("Clemson");
        ChristianHill.addLocation(sampleSnackMachineD);

        SnackMachine sampleSnackMachineE = new SnackMachine();
        sampleSnackMachineE.setLocation("Georgia State");
        ChristianHill.addLocation(sampleSnackMachineE);

        sampleSnackMachineA.setId("smA");
        sampleSnackMachineB.setId("smB");
        sampleSnackMachineC.setId("smC");
        sampleSnackMachineD.setId("smD");
        sampleSnackMachineE.setId("smE");

        sampleSnackMachineA.setMoney(1);
        sampleSnackMachineB.setMoney(2);
        sampleSnackMachineC.setMoney(3);
        sampleSnackMachineD.setMoney(4);
        sampleSnackMachineE.setMoney(5);
        when: "'Each SnackMachine' option is chosen"

        String amount = ChristianHill.eachSnackMachineCount();
        then: "Print each SnackMachine 'Total Amount'"

        amount == "Georgia State\n" +
                "\t[ID: smE | Money: 5.0] \n" +
                "Harvard\n" +
                "\t[ID: smA | Money: 1.0] \t[ID: smB | Money: 2.0] \t[ID: smC | Money: 3.0] \n" +
                "Clemson\n" +
                "\t[ID: smD | Money: 4.0]"
    }



    def "Op checks amount of money in all SnackMachine"() {

        given: "Op having access"

        Operator ChristianHill = new Operator();

        SnackMachine sampleSnackMachineA = new SnackMachine();
        sampleSnackMachineA.setLocation("Harvard");
        ChristianHill.addLocation(sampleSnackMachineA);

        SnackMachine sampleSnackMachineB = new SnackMachine();
        sampleSnackMachineB.setLocation("Harvard");
        ChristianHill.addLocation(sampleSnackMachineB);

        SnackMachine sampleSnackMachineC = new SnackMachine();
        sampleSnackMachineC.setLocation("Harvard");
        ChristianHill.addLocation(sampleSnackMachineC);

        SnackMachine sampleSnackMachineD = new SnackMachine();
        sampleSnackMachineD.setLocation("Clemson");
        ChristianHill.addLocation(sampleSnackMachineD);

        SnackMachine sampleSnackMachineE = new SnackMachine();
        sampleSnackMachineE.setLocation("Georgia State");
        ChristianHill.addLocation(sampleSnackMachineE);

        sampleSnackMachineA.setId("smA");
        sampleSnackMachineB.setId("smB");
        sampleSnackMachineC.setId("smC");
        sampleSnackMachineD.setId("smD");
        sampleSnackMachineE.setId("smE");

        sampleSnackMachineA.setMoney(1);
        sampleSnackMachineB.setMoney(2);
        sampleSnackMachineC.setMoney(3);
        sampleSnackMachineD.setMoney(4);
        sampleSnackMachineE.setMoney(5);

        when: "'All SnackMachine' option is chosen"

        String amount = ChristianHill.allSnackMachineCount();

        then: "Print All SnackMachines total amount combined"
        amount == "Total Amount of All SnackMachines: \$" + "15.0"
    }






    def "Op checks the amount of money in all SnackMachines by location"(){

        given: "Op has access"

        Operator ChristianHill = new Operator();

        SnackMachine sampleSnackMachineA = new SnackMachine();
        sampleSnackMachineA.setLocation("Harvard");
        ChristianHill.addLocation(sampleSnackMachineA);

        SnackMachine sampleSnackMachineB = new SnackMachine();
        sampleSnackMachineB.setLocation("Harvard");
        ChristianHill.addLocation(sampleSnackMachineB);

        SnackMachine sampleSnackMachineC = new SnackMachine();
        sampleSnackMachineC.setLocation("Harvard");
        ChristianHill.addLocation(sampleSnackMachineC);

        SnackMachine sampleSnackMachineD = new SnackMachine();
        sampleSnackMachineD.setLocation("Clemson");
        ChristianHill.addLocation(sampleSnackMachineD);

        SnackMachine sampleSnackMachineE = new SnackMachine();
        sampleSnackMachineE.setLocation("Georgia State");
        ChristianHill.addLocation(sampleSnackMachineE);

        sampleSnackMachineA.setId("smA");
        sampleSnackMachineB.setId("smB");
        sampleSnackMachineC.setId("smC");
        sampleSnackMachineD.setId("smD");
        sampleSnackMachineE.setId("smE");

        sampleSnackMachineA.setMoney(1);
        sampleSnackMachineB.setMoney(2);
        sampleSnackMachineC.setMoney(3);
        sampleSnackMachineD.setMoney(4);
        sampleSnackMachineE.setMoney(5);

        and: "a specified location"

        when: "'LocationAmount' option is chosen"

        String amount = ChristianHill.allSnackMachineCountByLocation("Harvard");

        then: "print totalAmount of All SnackMachines in a location"
        amount == "Total amount in Harvard " + "6.0"
    }

}