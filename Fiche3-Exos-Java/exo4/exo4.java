package exo4;

public class exo4 
{
    public static void main(String[] args)
    {
        int count=0;
        int start=1;
        int end=10;

        for(int i = start; i<= end; i++)
        {
            count+= Math.pow(i,2);
        }
        System.out.print("La somme des carrés des nombres entre "+ start + " et " + end + " est " + count);
    }    
}
