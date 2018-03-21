package hello

import spock.lang.Specification

class OperatorSpec extends Specification {

    def "Operator needs security code for authorization to perform action"(){

        given: "Password is set"
        Operator myOP = new Operator();

        when: "Correct password is entered"
        boolean access = myOP.checkPassword("password123");

        then: "Gains access for actions"
        if(access){
            println("You have access.  Please proceed ");
        } else{
            println("Please put in a valid access credentials");
        }
    }


}