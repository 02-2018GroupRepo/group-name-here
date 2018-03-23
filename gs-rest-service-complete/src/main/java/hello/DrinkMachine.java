package hello;

public class DrinkMachine extends Machine{
  
	
	public DrinkMachine(String id, String location, String company) {
		super();
		this.location = location;
		this.id = id;
		this.companyName = company;
		this.total = 0;
        this.coinManager = new CoinManager();

    }


  private  int[] cokeCannedDrink = new int[6];
  private  int[] fantaCannedDrink = new int[6];
  private  int[] dietCokeCannedDrink = new int[6];
  private  int[] drpepperBottledDrink = new int[5];
  private  int[] pepsiBottledDrink = new int[5];


   private int numOfProducts;

    public void addProduct(){
        for(int i = 0; i < 5;i++){
            if(i >=2){
                for(int j  = 0; j < 6; j++) {

                    cokeCannedDrink[j] = 12;
                    dietCokeCannedDrink[j] = 12;
                    fantaCannedDrink[j] = 12;
                }
            }else{
                for(int j = 0; j < 5;j++) {

                    pepsiBottledDrink[i] = 8;
                    drpepperBottledDrink[i] = 8;
                }
            }
        }
    }
    public int getAmountOfCannedCokes(){
        return getAmountOfProducts(cokeCannedDrink);
    }public int getAmountOfCannedFanta(){
        return getAmountOfProducts(fantaCannedDrink);
    }public int getAmountOfCannedSprite(){
        return getAmountOfProducts(dietCokeCannedDrink);
    }public int getAmountOfBottledPepsi(){
        return getAmountOfProducts(pepsiBottledDrink);
    }public int getAmountOfBottledSchwepps(){
        return getAmountOfProducts(drpepperBottledDrink);
    }


    public int getAmountOfProducts(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum+=arr[i];
        }
        return sum;

    }
}

