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

    public int getSpaces(){
      return getTotalCompartments() * 10;
    }

    public String dispense(String product, int compartment){
        String productBought = "";
      switch (product){
          case "Almonds":
              Almonds[compartment - 1] -= 1;
              productBought = "Almonds";
              break;
          case "Cheetos":
              Cheetos[compartment - 1] -= 1;
              productBought = "Cheetos";
              break;
          case "Snickers":
              Snickers[compartment - 1] -= 1;
              productBought = "Snickers";
              break;
          case "Fritos":
              Fritos[compartment - 1] -= 1;
              productBought = "Fritos";
              break;
          case "Crunchbar":
              Crunchbar[compartment - 1] -= 1;
              productBought = "Crunchbar";
              break;
      }
      return productBought;
    }

    public void addProduct(){
        Almonds[0] = 10;
        Almonds[1] = 10;
        Almonds[2] = 10;
        Almonds[3] = 10;
        Almonds[4] = 10;
    }
}

