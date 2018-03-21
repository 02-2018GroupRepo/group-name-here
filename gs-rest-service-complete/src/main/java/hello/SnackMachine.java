package hello;

public class SnackMachine extends Machine{
    private int[] Almonds = {10,9,5,10,8};
    private int[] Cheetos = {10,9,5,10,6};
    private int[] Snickers = {10,9,5,10,7};
    private int[] Fritos = {10,9,5,10,9};
    private int[] Crunchbar = {10,9,5,10,5};



    private  int sum = 0;



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
    /*
    public void getProductQty(){
        for(int i = 0;i < 5;i++){
            int ShelfNum = i;
            switch(ShelfNum){
                case 0:
                     numOfProducts = getAmountOfProducts(Almonds);
                    System.out.println("The number of almonds in the machine is "+numOfProducts);
                case 1:
                     numOfProducts = getAmountOfProducts(Snickers);
                    System.out.println("The number of snickers in the machine is "+numOfProducts);
                    case 2:
                     numOfProducts = getAmountOfProducts(Fritos);
                    System.out.println("The number of fritors in the machine is "+numOfProducts);
                    case 3:
                     numOfProducts = getAmountOfProducts(Crunchbar);
                    System.out.println("The number of crunchbars in the machine is "+numOfProducts);
                    case 4:
                     numOfProducts = getAmountOfProducts(Cheetos);
                    System.out.println("The number of cheetos in the machine is "+numOfProducts);



            }

        }

    }
    */

    public int getAmountOfProducts(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum+=arr[i];
        }
        return sum;

    }
}
