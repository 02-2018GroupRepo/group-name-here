package hello;

public class SnackMachine extends Machine{
    private int[] Almonds = {10,9,5,10,8};
    private int[] Cheetos = {10,9,5,10,6};
    private int[] Snickers = {10,9,5,10,7};
    private int[] Fritos = {10,9,5,10,9};
    private int[] Crunchbar = {0,0,0,0,0};
    
    public SnackMachine(String id, String location, String company) {
		super();
		this.location = location;
		this.id = id;
		this.companyName = company;
		this.total = 0;
		this.Almonds = Almonds;
		this.Cheetos = Cheetos;
		this.Snickers = Snickers;
		this.Fritos = Fritos;
		this.Crunchbar = Crunchbar;
		this.coinManager = new CoinManager();
	}

    int numOfProducts;
    public int getAmountOfAlmonds(){
        return getAmountOfProducts(Almonds);
    }public int getAmountOfCheetos(){
        return getAmountOfProducts(Cheetos);
    }public int getAmountOfSnickers(){
        return getAmountOfProducts(Snickers);
    }public int getAmountOfFritos(){
        return getAmountOfProducts(Fritos);
    }public int getAmountOfCrunchBars(){
        return getAmountOfProducts(Crunchbar);
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
		case "13":
			return this.getAmountOfCheetos();

		case "2":
			return this.getAmountOfCheetos();
			
		case "9":
			return this.getAmountOfSnickers();
			
		case "4":
			return this.getAmountOfFritos();
			
		case "10":
			return this.getAmountOfCrunchBars();
		
		default:
			return 0;
		}
    }
    
    public String dispense(String product, int compartment) {
        String productBought = "";
        switch (product) {
            case "Almonds":
                if (Almonds[compartment] > 0) {
                    Almonds[compartment] -= 1;
                    System.out.println(Almonds[compartment]);
                    productBought = "Almonds";
                    //System.out.println("Purchased" +" " + productBought);
                    //System.out.println(Almonds[compartment] +" " + productBought + " left in compartment" +  ".");
                    break;
                } else {
                    productBought = "empty";
                    //System.out.println(productBought);
                    break;
                }
            case "Cheetos":
                if (Cheetos[compartment] > 0) {
                    Cheetos[compartment] -= 1;
                    productBought = "Cheetos";
                    //System.out.println("Purchased" +" " + productBought +  ".");
                    //System.out.println(Cheetos[compartment] +" " + productBought + " left in compartment" +  ".");
                    break;
                } else {
                    productBought = "empty";
                    //System.out.println(productBought);
                    break;
                }
            case "Snickers":
                if (Snickers[compartment] > 0) {
                    Snickers[compartment] -= 1;
                    productBought = "Snickers";
                    //System.out.println("Purchased" +" " + productBought +  ".");
                    //System.out.println(Snickers[compartment] +" " + productBought + " left in compartment" +  ".");
                    break;
                } else {
                    productBought = "empty";
                    //System.out.println(productBought);
                    break;
                }
            case "Fritos":
                if (Fritos[compartment] > 0) {
                    Fritos[compartment] -= 1;
                    productBought = "Fritos";
                    //System.out.println("Purchased" +" " + productBought +  ".");
                    //System.out.println(Fritos[compartment] +" " + productBought + " left in compartment" +  ".");
                    break;
                } else {
                    productBought = "empty";
                    //System.out.println(productBought);
                    break;
                }
            case "Crunchbar":
                if (Crunchbar[compartment] > 0) {
                    Crunchbar[compartment] -= 1;
                    productBought = "Crunchbar";
                    //System.out.println("Purchased" +" " + productBought +  ".");
                    //System.out.println(Crunchbar[compartment] +" " + productBought + " left in compartment" +  ".");
                    break;
                } else {
                    productBought = "empty";
                    //System.out.println(productBought);
                    break;
                }
        }
        return productBought;
    }
}
