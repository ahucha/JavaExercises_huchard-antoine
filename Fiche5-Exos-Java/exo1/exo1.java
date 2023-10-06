package exo1;
import java.util.ArrayList;

import Class.GenerateArray;


public class exo1 
{
    public static void main(String[] args) 
    {

        GenerateArray.generate(10, 100);
        ArrayList<Integer> list = GenerateArray.getList();

        System.out.println("Liste d'origine : " + list);

        System.out.println("Liste triée : " + listTrieCroissant(list));
    }

    public static ArrayList<Integer> listTrieCroissant(ArrayList<Integer> list)
    {
        int temp=0;
        for(int i = 0; i<list.size(); i++)
        {
            for(int j = 0; j<list.size(); j++)
            {
                if(list.get(j) > list.get(i))
                {
                    temp = list.get(j);
                    list.set(j, list.get(i));
                    list.set(i,temp);

                }
            }
        }
        return list;
    }
}