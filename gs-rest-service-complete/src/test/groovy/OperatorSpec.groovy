import hello.Operator
import hello.Product
import hello.SnackMachine
import spock.lang.Specification


class OperatorSpec extends Specification {

    def "Print quanity of each product in Snackmachine"() {
        given: "a machine id and operator access code is valid"
        String id = "0001"
        String code = "123"

        when: "the operator requests Snackmachine inventory "
        Operator sampleOperator = new Operator(id, code)
        SnackMachine snackMachine = new SnackMachine();
        int almondqty = snackMachine.getAmountOfAlmonds()
        int cheetoqty = snackMachine.getAmountOfCheetos()
        int fritoqty = snackMachine.getAmountOfFritos()
        int snickerqty = snackMachine.getAmountOfSnickers()
        int crunchbarqty = snackMachine.getAmountOfCrunchBars()



        then: " the machine should print the quantity of each product"
        almondqty == 42
        cheetoqty == 40
        fritoqty == 43
        snickerqty == 41
        crunchbarqty == 39
    }

}