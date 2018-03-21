import spock.lang.Specification

class SnackMachineSpec extends Specification {

        def "creating a snack machine" () {
            given: "a vending company"
            VendingCompany groupNameHere = new VendingCompany()
            when:"we create the snack machine"
            SnackMachine snackmachine_one = new SnackMachine()
            then:"the machine will have 5 shelves, each with 5 compartments"
            snackmachine_one.getTotalCompartments()
            snackmachine_one.getTotalCompartments() == 25
            and:"each compartment has 10 full spaces"
            snackmachine_one.getSpaces() == 250
        }
    def "getting a product"() {
        given: "a snack machine has been created"
        SnackMachine snackmachine_one = new SnackMachine()
        when:"the customer selects a product and compartment"
        and: "each compartment has products"
        snackmachine_one.addProduct()
        String name_of_item = snackmachine_one.dispense("Cheetos", 2)
        then:"the machine returns the first product in the selected compartment"
        name_of_item.equals("Cheetos")
    }

}