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
}

