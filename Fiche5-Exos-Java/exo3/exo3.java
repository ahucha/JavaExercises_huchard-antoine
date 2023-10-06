package exo3;
import java.util.ArrayList;
import java.util.Scanner;

import Class.GenerateArray;
import exo1.exo1;


public class exo3 
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        GenerateArray.generate(10, 100);
        ArrayList<Integer> list = GenerateArray.getList();

        System.out.println("Liste d'origine : " + list);
        int nbScan = 0;
        for(int i = 0; i<5;)
        {
            System.out.println("Entrer un nombre : ");
            if(scan.hasNextInt())
            {
                nbScan = scan.nextInt();
                list.add(nbScan);
                i++;
            }
            else
            {
                System.out.println("La saisie n'est pas un nombre");
                scan.nextLine();
            }
        }
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