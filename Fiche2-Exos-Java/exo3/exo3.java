package exo3;
import java.util.ArrayList;

public class exo3 {
    public static void main(String[] args)
     {
        ArrayList<String> quotations = new ArrayList<>();
        quotations.add("Quand Paris s\'enrhume, l\'Europe a froid");
        quotations.add("S'il y a un diamant dans la poitrine, il brille sur le visage");
        quotations.add("La joie de vivre n'est pas un but, mais un devoir");

        for(String phrase: quotations)
        {
            System.out.println(phrase + " : " + countVowels(phrase));
        }
    }

    private static int countVowels(String str)
    {
        str = str.toLowerCase();
        int nbVowels = 0;

        for(int i =0; i < str.length(); i++)
        {
            char lettre = str.charAt(i);
            if (lettre == 'a' || lettre == 'e' || lettre == 'i' || lettre == 'o' || lettre == 'u' || lettre == 'y') 
            {
               nbVowels ++; 
            }
        }
        return nbVowels;
    }
}