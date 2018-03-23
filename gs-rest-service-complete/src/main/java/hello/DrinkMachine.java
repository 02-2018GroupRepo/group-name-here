package hello;

public class DrinkMachine extends Machine{
	
	private  int[] cokeCannedDrink = {12, 12, 12, 7, 7, 7};
	private  int[] fantaCannedDrink = {12, 12, 12, 7, 7, 7};
	private  int[] dietCokeCannedDrink = {12, 12, 12, 7, 7, 7};
	private  int[] drpepperBottledDrink = {5, 4, 5, 4, 7};
	private  int[] pepsiBottledDrink = {5, 4, 5, 4, 7};
  
	
	public DrinkMachine(String id, String location, String company) {
		super();
		this.location = location;
		this.id = id;
		this.companyName = company;
		this.total = 0;
		this.cokeCannedDrink = cokeCannedDrink;
		this.fantaCannedDrink = fantaCannedDrink;
		this.dietCokeCannedDrink = dietCokeCannedDrink;
		this.drpepperBottledDrink = drpepperBottledDrink;
		this.pepsiBottledDrink = pepsiBottledDrink;
		this.coinManager = new CoinManager();
	}

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
    }public int getAmountOfCannedDietCoke(){
        return getAmountOfProducts(dietCokeCannedDrink);
    }public int getAmountOfBottledPepsi(){
        return getAmountOfProducts(pepsiBottledDrink);
    }public int getAmountOfBottledDrPepper(){
        return getAmountOfProducts(drpepperBottledDrink);
    }


    public int getAmountOfProducts(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum+=arr[i];
        }
        return sum;

    }
    
    public int validateInventory(String id) {
    		switch (id) {
			case "30":
				System.out.println(this.getAmountOfCannedCokes());
				return this.getAmountOfCannedCokes();

			case "26":
				return this.getAmountOfCannedFanta();
				
			case "18":
				return this.getAmountOfCannedDietCoke();
				
			case "19":
				return this.getAmountOfBottledPepsi();
				
			case "21":
				return this.getAmountOfBottledDrPepper();
			
			default:
				return 0;
			}
    }
}

