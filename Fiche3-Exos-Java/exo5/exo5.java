package exo5;
import java.util.ArrayList;
public class exo5 
{
    public static void main(String[] args)
    {
        ArrayList<Integer> nbArray = new ArrayList<>();
        nbArray.add(75);
        nbArray.add(80);
        nbArray.add(90);
        nbArray.add(95);
        nbArray.add(85);
        System.out.print("La moyenne de la liste est : " + averegaeCalc(nbArray));
    }        

    private static int averegaeCalc(ArrayList<Integer> numbers)
    {
        int sum=0;
        int nbElements = numbers.size();
        for(int nombre: numbers)
        {
            sum+=nombre;
        }
        return sum/nbElements;
    }
}
