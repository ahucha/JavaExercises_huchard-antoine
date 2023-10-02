package exo4;

public class exo4 {
    public static void main(String[] args) {

        String str = "Hello World !";
        int i = 0;

        while(i< str.length())
        {
            System.out.print(str.charAt(i));
            if(str.length() != i)
            {
                System.out.print(" ");
            }
            i = i + 1;
        }
    }
}
