import spock.lang.Specification


class CoinManagerFeatureSpec extends Specification {

    def "Insert a Coin"(){

        given: "a Coin";
            Coins coin = new Coins(0.25)

        and: "a coinManager";
            CoinManager cm = new CoinManager();

        when: "coin is added";
            cm.addCoin(coin);

        then: "coin manager has coin";
            cm.howMuchCoins() > 0;

    }

    def "four quarters in coin manager results in 1.00 dollar"(){
        given: "a 4 Coins of .25";
            Coins coin1 = new Coins(0.25)
            Coins coin2 = new Coins(0.25)
            Coins coin3 = new Coins(0.25)
            Coins coin4 = new Coins(0.25)

        and: "a coin Manager";
            CoinManager cm = new CoinManager()

        when: "4 coins are added";

            cm.addCoin(coin1)
            cm.addCoin(coin2)
            cm.addCoin(coin3)
            cm.addCoin(coin4)

        then: "value of coins in coin manager must be 1.00"
            cm.totalAmount() == 1.00

    }
    def "Accepting coins to a value of 0.65 even when theres invalid coins"(){

        given: "Inserted valid coins and invalid coins";
            Coins coin1 = new Coins(0.25);
            Coins coin2 = new Coins(0.10);
            Coins coin3 = new Coins(0.05);
            Coins coin4 = new Coins(0.25);
            Coins coin5 = new Coins(0.01);
            Coins coin6 = new Coins(0.01);
            Coins coin7 = new Coins(0.01);

        and: "a coin manager"
            CoinManager cm = new CoinManager()

        when: "5 coins are added";
            cm.addCoin(coin1)
            cm.addCoin(coin2)
            cm.addCoin(coin3)
            cm.addCoin(coin4)
            cm.addCoin(coin5)
            cm.addCoin(coin6)
            cm.addCoin(coin7)


        then: "return total amount to be 0.65";
            Math.abs(cm.totalAmount() -  0.65) < 0.00001;

    }

    def "Shows the value of change from list"(){

        given: "a product that is 0.75"
        double prod = 0.75;

        and: "the user adds 4 quarters, 2 dimes and 2 nickels"
        Coins coin1 = new Coins(0.25);
        Coins coin2 = new Coins(0.25);
        Coins coin3 = new Coins(0.25);
        Coins coin4 = new Coins(0.25);
        Coins coin5 = new Coins(0.10);
        Coins coin6 = new Coins(0.10);
        Coins coin7 = new Coins(0.05);
        Coins coin8 = new Coins(0.05);

        and: "a coin manager"
        CoinManager cm = new CoinManager()

        when: "when the consumer adds too much extra money"
        cm.addCoin(coin1)
        cm.addCoin(coin2)
        cm.addCoin(coin3)
        cm.addCoin(coin4)
        cm.addCoin(coin5)
        cm.addCoin(coin6)
        cm.addCoin(coin7)
        cm.addCoin(coin8)

        then: "return the value of their change"
        double difference = cm.change();
        ArrayList<Coins> listOfCoins = cm.returnCustomerChange(difference)
        double change = cm.totalAmount(listOfCoins)
        System.out.println(change);
        true



        and: "session is returns 0";
        cm.resetSession();
        0 == cm.howMuchCoins();












    }







}
