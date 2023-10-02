package exo2;
import java.util.ArrayList;

public class exo2
{
    public static void main(String[] args)
    {
        if(args.length != 1)
        {
            System.out.print("La variable args est vide");
            return;
        }
    
        ArrayList<String> tab = new ArrayList<>();
        tab.add("kiwi");
        tab.add("pomme");
        tab.add("poire");
        tab.add("lithci");
        tab.add("rhubarbe");

        int findIndex = findFruit(tab, args[0]);

        if(findIndex == -1)
        {
            System.out.print(args[0] + " n'est pas dans le tableau !");
        }
        else
        {
            System.out.print("Le fruit " + args[0] + " est à l'index " + findIndex);
        }

    }

    private static int findFruit(ArrayList<String> tab, String str)
    {
        for(int i = 0; i<tab.size(); i++)
        {
            if(tab.get(i).equals(str))
            {
                return i;
            }
        }
        return -1;
    }
}

