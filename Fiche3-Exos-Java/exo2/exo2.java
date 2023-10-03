package exo2;
public class exo2
{
    public static void main(String[] args)
    {
        if(args.length !=2)
        {
            System.out.print("Il faut 2 arguments pour le min et le max");
            return;
        }
        int min = Integer.parseInt(args[0]);
        int max = Integer.parseInt(args[1]);
        
        String result ="";
        for(int i= min; i<= max; i++)
        {
            if(i%3==0 && i%5 !=0)
            {
                result = "Fizz";
            }
            else if(i%5==0 && i%3 !=0)
            {
                result = "Buzz";
            }
            else if(i%3 == 0 && i%5 == 0)
            {
                result = "FizzBuzz";
            }
            else
            {
                result = Integer.toString(i);
            }
            System.out.print(result + " ");
        }
    }
}