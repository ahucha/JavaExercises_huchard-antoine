package exo3;

public class exo3 
{
    public static void main(String[] args)
    {
         int count=0;
         int start=0;
         int end=50;

         for(int i = start; i<= end; i++)
         {
            if(i%2==0)
            {
                count+= i;
            }
         }
         System.out.print("La somme des nombres pairs entre "+ start +" et " + end + " est : " + count);
    }   
}
