package exo8;

public class exo8 {
    public static void main(String[] args) {
        String[] colors = {"bleu", "rouge", "jaune"};
        for(String value : colors)
        {
            if(value == "bleu")
            {
                System.out.println("La couleur préférée de Louis est le " +value);
            }
            else if(value == "rouge")
            {
                System.out.println("Pour sa peinture, Andrée a utilisé du " +value);
            }
            else if(value == "jaune")
            {
                System.out.println("Anis n'a pas de chemise " +value);
            }
        }
    }
}
