package hello;

public class SnackMachine extends Machine{
    private int[] Almonds = {10,9,5,10,8};
    private int[] Cheetos = {10,9,5,10,6};
    private int[] Snickers = {10,9,5,10,7};
    private int[] Fritos = {10,9,5,10,9};
    private int[] Crunchbar = {10,9,5,10,5};
    
    public SnackMachine(String id, String location, String company) {
		super();
		this.location = location;
		this.id = id;
		this.companyName = company;
		this.total = 0;
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
}
