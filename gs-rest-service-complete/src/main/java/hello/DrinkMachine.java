package hello;

public class DrinkMachine {
  private   int[] cokeCannedDrink = new int[6];
  private    int[] fantaCannedDrink = new int[6];
  private   int[] spriteCannedDrink = new int[6];
  private   int[] schweppsBottledDrink = new int[5];
  private   int[] pepsiBottledDrink = new int[5];


    private  int sum = 0;

   private int numOfProducts;

    public void addProduct(){
        for(int i = 0; i < 5;i++){
            if(i >=2){
                for(int j  = 0; j < 6; j++) {

                    cokeCannedDrink[j] = 12;
                    spriteCannedDrink[j] = 12;
                    fantaCannedDrink[j] = 12;
                }
            }else{
                for(int j = 0; j < 5;j++) {

                    pepsiBottledDrink[i] = 8;
                    schweppsBottledDrink[i] = 8;
                }
            }
        }
    }
    public int getAmountOfCannedCokes(){
        return getAmountOfProducts(cokeCannedDrink);
    }public int getAmountOfCannedFanta(){
        return getAmountOfProducts(fantaCannedDrink);
    }public int getAmountOfCannedSprite(){
        return getAmountOfProducts(spriteCannedDrink);
    }public int getAmountOfBottledPepsi(){
        return getAmountOfProducts(pepsiBottledDrink);
    }public int getAmountOfBottledSchwepps(){
        return getAmountOfProducts(schweppsBottledDrink);
    }


    public int getAmountOfProducts(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum+=arr[i];
        }
        return sum;

    }
}

