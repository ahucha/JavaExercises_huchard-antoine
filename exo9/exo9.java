package exo9;

public class exo9 {
    public static void main(String[] args) {
        int[] numbers = {21565, 3412, 180, 1556, 182, 84, 15};
        boolean premierNombre = true;
        for(int value : numbers)
        {
            if(value%3!=0)
            {
                if(premierNombre==false)
                {
                    System.out.print(", ");
                }
                System.out.print(value);
            }
            premierNombre = false;
        }
    }
}
