package Class;
import java.util.ArrayList;
import java.util.Random;

public class GenerateArray 
{
    private static ArrayList<Integer> list = new ArrayList<>();

    public static void generate(int tailleTab, int nbMax)
    {
        Random rand = new Random();

        while(list.size() < tailleTab)
        {
            int nbRand = rand.nextInt(nbMax) + 1;
            if(!list.contains(nbRand))
            {
                list.add(nbRand);
            }
        }
    }

    public static ArrayList<Integer> getList()
    {
        return list;
    }

    public static void main(String[] args)
    {
        generate(10, 100);
        System.out.print(getList());
    }

    public static void addItem(int nb)
    {
        list.add(nb);
    }

}
