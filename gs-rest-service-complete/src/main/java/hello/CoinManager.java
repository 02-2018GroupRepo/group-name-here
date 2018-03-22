package hello;

import java.util.ArrayList;
import java.util.HashMap;

public class CoinManager {

    private ArrayList<Coins> coinList = new ArrayList<Coins>();
    private HashMap<Double, Integer> coinLog;


    //Validates coins
    public void addCoin(Coins c){
        if(c.getValue() != -1){
            this.coinList.add(c);
        }
        else{
            System.out.println("Please insert Nickels, Dimes and Quarters");
        }
    }

    //
    public int howMuchCoins(){
        return this.coinList.size();
    }

    //Get total amount of valid coins
    public double totalAmount(){
        double total = 0;
        for( Coins c : this.coinList){
            total += c.getValue();
        }
        return total;
    }

    //Coins that are currently in the machine
    public CoinManager(){
        coinLog = new HashMap<>();
        coinLog.put(Coins.getQUARTER(), 15);
        coinLog.put(Coins.getDIME(), 15);
        coinLog.put(Coins.getNICKEL(), 15);
        //resetSession();

    }

    //return change
    public void returnCustomerChange(double difference){
        do {
            if (difference % Coins.getQUARTER() == 0) {
                coinLog.put(Coins.getQUARTER(), coinLog.get(Coins.getQUARTER()) - 1);
                difference -= Coins.getQUARTER();
            } else if (difference % Coins.getDIME() == 0) {
                coinLog.put(Coins.getDIME(), coinLog.get(Coins.getDIME()) - 1);
                difference -= Coins.getDIME();
            } else if (difference % Coins.getNICKEL() == 0) {
                coinLog.put(Coins.getNICKEL(), coinLog.get(Coins.getNICKEL()) - 1);
                difference -= Coins.getNICKEL();
            }

        }while (difference > 0);


    }
    
}
