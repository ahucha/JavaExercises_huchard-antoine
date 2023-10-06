package exo2;
import java.util.ArrayList;

import Class.GenerateArray;


public class exo2 
{
    public static void main(String[] args) 
    {
        GenerateArray.generate(10, 100);
        ArrayList<Integer> list = GenerateArray.getList();

        System.out.println("Liste d'origine : " + list);

        int temp=0;

        System.out.println("Liste triée : " + listTrieDeroissant(list));
    }

    public static ArrayList<Integer> listTrieDeroissant(ArrayList<Integer> list)
    {
        int temp=0;
        for(int i = 0; i<list.size(); i++)
        {
            for(int j = 0; j<list.size(); j++)
            {
                if(list.get(j) < list.get(i))
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