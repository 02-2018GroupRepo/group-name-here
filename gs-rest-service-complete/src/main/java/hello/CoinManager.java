package hello;



import java.text.DecimalFormat;

import java.util.ArrayList;

import java.util.HashMap;



public class CoinManager {



    private ArrayList<Coins> coinList = new ArrayList<Coins>();

    private ArrayList<Coins> customerCoinList = new ArrayList<Coins>();

    private HashMap<String, Integer> coinLog;

    //Coins that are currently in the machine

    public CoinManager(){

        coinLog = new HashMap<>();

        coinLog.put("QUARTER", 15);

        coinLog.put("DIME", 15);

        coinLog.put("NICKEL", 15);

        resetSession();



    }



    //Validates coins

    public void addCoin(Coins c){

        if(c.getValue() != -1){

            this.customerCoinList.add(c);

        }

        else{

            System.out.println("Please insert Nickels, Dimes and Quarters");

        }

    }



    //

    public int howMuchCoins(){

        return this.customerCoinList.size();

    }



    //Get total amount of valid coins

    public double totalAmount(){

        double total = 0;

        for( Coins c : this.customerCoinList){

            total += c.getValue();

        }

        return total;

    }



    public double totalAmount(ArrayList<Coins> list){

        double total = 0;

        for( Coins c : list){

            total += c.getValue();

        }

        return total;

    }









    //return change

    public ArrayList<Coins> returnCustomerChange(double difference){

        Coins quarter = new Coins(0.25);

        Coins dime = new Coins(0.10);

        Coins nickel = new Coins(0.05);



        ArrayList<Coins> change = new ArrayList<Coins>();

        DecimalFormat df = new DecimalFormat("#.00");











        do {

            difference = Double.parseDouble(df.format(difference));



            if (Double.parseDouble(df.format(difference % quarter.getValue())) == 0) {

                coinLog.put("QUARTER", coinLog.get("QUARTER") - 1);

                difference -= quarter.getValue();

                System.out.println("ENTERED QUARTERS");

                change.add(quarter);





            } else if (Double.parseDouble(df.format(difference % dime.getValue())) == 0) {

                coinLog.put("DIME", coinLog.get("DIME") - 1);

                difference -= dime.getValue();

                System.out.println("ENTERED DIMES");

                change.add(dime);



            } else if (Double.parseDouble(df.format(difference % nickel.getValue())) == 0){

                coinLog.put("NICKEL", coinLog.get("NICKEL") - 1);

                difference -= nickel.getValue();

                System.out.println("ENTERED NICKELS");

                change.add(nickel);

            }

            System.out.println(difference);

//            break;





        }while (difference > 0);





        return change;

    }



//    public double change(Product p){

//

//         return this.totalAmount() - //p.getPrice()???? ;

//

//    }



    public double change(){



        return this.totalAmount() - 0.75 ;



    }



    public void resetSession(){

        customerCoinList.clear();





    }


    public HashMap<String, Integer> getCoinLog() {
        return coinLog;
    }
}
