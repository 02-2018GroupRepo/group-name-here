import java.util.ArrayList;

public class CoinManager {

    private ArrayList<Coins> coinList = new ArrayList<Coins>();


    public void addCoin(Coins c){
        if(c.getValue() != -1){
            this.coinList.add(c);
        }
        else{
            System.out.println("Please insert Nickels, Dimes and Quarters");
        }
    }

    public int howMuchCoins(){
        return this.coinList.size();
    }

    public double totalAmount(){
        double total = 0;
        for( Coins c : this.coinList){
            total += c.getValue();
        }
        return total;
    }


}
