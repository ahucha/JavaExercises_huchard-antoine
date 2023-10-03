public class exo1
{
    public static void main(String[] args)
    {
        String result ="";
        for(int i=1; i<=100; i++)
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