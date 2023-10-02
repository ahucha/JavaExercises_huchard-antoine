package exo5;

public class exo5 {

    public static void main(String[] args) {

        String str = "abcdefghijklmnopqrstuvwxyz";
        int i = 0;

        while(i<str.length())
        {
            if(i%2!=0)
            {
                System.out.print(str.charAt(i));
            }
            i+=1;
        }
    }

}
