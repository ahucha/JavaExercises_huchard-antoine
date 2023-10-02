package exo1;
import java.util.ArrayList;

public class exo1 {
    public static void main(String[] args)
     {
        ArrayList<Integer> stock = new ArrayList<>();
        stock.add(14);
        stock.add(887);
        stock.add(58);
        stock.add(713);
        stock.add(179);
        stock.add(512);
        stock.add(786);
        stock.add(29);

        System.out.println("Contenu de stock : " + sum(stock));
    }

    private static int sum(ArrayList<Integer> stock)
    {
       int sum = 0;
       for(int nombre : stock) 
       {
        sum += nombre;
       }
       return sum;
    }
}