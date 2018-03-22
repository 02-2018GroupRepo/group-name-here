import spock.lang.Specification


class CoinFeatureSpec extends Specification {

        def "Is Coin invalid?"(){

            given: "double value 0.96"
                double value = 0.96

            and: "When a coin is created"
                Coins coin = new Coins(value);

            when: "it is invalid";
                double result = coin.getValue()

            then: "then it is unacceptable"
                result == -1;
        }


        def "Is Coin valid?"(){

            given: "double value of nickel, dime, or quarter"
            double nickel = 0.05
            double dime = 0.10
            double quarter = 0.25

            and: "When coins is created"
            Coins coin1 = new Coins(nickel);
            Coins coin2 = new Coins(dime);
            Coins coin3 = new Coins(quarter);


            when: "are they valid";
            double result1 = coin1.getValue()
            double result2 = coin2.getValue()
            double result3 = coin3.getValue()

            then: "then it is acceptable"
            result1 == nickel || result2 == dime || result1 == quarter
        }



}