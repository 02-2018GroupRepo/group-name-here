public class SnackMachine {
    private int [] Almonds = new int[5];
    private int [] Cheetos = new int[5];
    private int [] Snickers = new int[5];
    private int [] Fritos = new int[5];
    private int [] Crunchbar = new int[5];
    private int TotalSpaces = 0;
    public int getTotalCompartments(){
        return Almonds.length + Cheetos.length + Snickers.length + Fritos.length + Crunchbar.length;
    }
    public void addProduct(){
        for (int i = 0; i < 5; i ++
             ) {
            Almonds[i] = 10;
            Cheetos[i] = 10;
            Snickers[i] = 10;
            Fritos[i] = 10;
            Crunchbar[i] = 10;
        }
    }

    public int getSpaces(){
      return getTotalCompartments() * 10;
    }

    public String dispense(String product, int compartment){
        String productBought = "";
      switch (product){
          case "Almonds":
              Almonds[compartment] -= 1;
              productBought = "Almonds";
              System.out.println(productBought + " " +  Almonds[compartment]);
              break;
          case "Cheetos":
              Cheetos[compartment] -= 1;
              productBought = "Cheetos";
              System.out.println(productBought + " " +  Cheetos[compartment]);
              break;
          case "Snickers":
              Snickers[compartment] -= 1;
              productBought = "Snickers";
              System.out.println(productBought + " " +  Snickers[compartment]);
              break;
          case "Fritos":
              Fritos[compartment] -= 1;
              productBought = "Fritos";
              System.out.println(productBought + " " +  Fritos[compartment]);
              break;
          case "Crunchbar":
              Crunchbar[compartment] -= 1;
              productBought = "Crunchbar";
              System.out.println(productBought+ " " + Crunchbar[compartment]);
              break;

      }
      return productBought;
    }


}

