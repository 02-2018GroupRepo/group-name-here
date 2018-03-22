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
        and: "the machine has products"
        snackmachine_one.addProduct()
        String name_of_item = snackmachine_one.dispense("Fritos", 2)
        and: "the compartment is not empty"
        snackmachine_one.addProduct()
//      String empty_row = snackmachine_one.dispense("Cheetos", 3)
//        !!!! To test that an empty row will return "empty" , the product value must be set to 0 in addProduct
        then:"the machine returns the first product in the selected compartment"
        name_of_item.equals("Fritos")
//        empty_row.equals("empty")
    }
    def "check product dispense" () {
        given:"a product has been purchased"
        SnackMachine snackmachine_one = new SnackMachine()
        snackmachine_one.addProduct()
        when:"the product is dispensed"
        String name_of_item = snackmachine_one.dispense("Crunchbar", 2)
        then:"check inventory again to confirm sale"
        name_of_item.equals("Crunchbar")
    }
}