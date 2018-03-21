public class Coins {

    private final double NICKEL = 0.05;
    private final double DIME= 0.10;
    private final double QUARTER= 0.25;
    private double currentValue;

    public Coins(double value){
        if(value == QUARTER){
            this.currentValue = QUARTER;
        }
        else if(value == DIME){
            this.currentValue = DIME;
        }
        else if(value ==  NICKEL){
            this.currentValue = NICKEL;
        }
        else{
            this.currentValue = -1;
        }


    }

    public double getValue(){
        return currentValue;
    }

}
