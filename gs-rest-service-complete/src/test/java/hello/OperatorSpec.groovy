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
        sampleMachineA.setLocation("Atlanta");
        ChristianHill.addLocation(sampleMachineA);

        Machine sampleMachineB = new Machine();
        sampleMachineB.setLocation("Atlanta");
        ChristianHill.addLocation(sampleMachineB);

        Machine sampleMachineC = new Machine();
        sampleMachineC.setLocation("Atlanta");
        ChristianHill.addLocation(sampleMachineC);

        Machine sampleMachineD = new Machine();
        sampleMachineD.setLocation("Clemson");
        ChristianHill.addLocation(sampleMachineD);

        Machine sampleMachineE = new Machine();
        sampleMachineE.setLocation("Georgia State");
        ChristianHill.addLocation(sampleMachineE);

        when: "Machine location is selected"

        then: " Add the machine to location list and set the machine's location"

        ChristianHill.arrMachine == ["Atlanta": [sampleMachineA, sampleMachineB, sampleMachineC],
                                     "Clemson": [sampleMachineD], "Georgia State": [sampleMachineE]]

    }

    def "Operator wants to remove a machine from the list"(){

       given: "Op has access"

        and: "a machine"



       then: "Remove machine from location list"
    }

}