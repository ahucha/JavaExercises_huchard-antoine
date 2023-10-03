package Morpion_simple;
import java.util.Random;
import java.util.Scanner;

public class Morpion_simple 
{
    public static void main(String[] args) 
    {
        String[][] tabJeu = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        boolean joueur1Tour = true; // True si c'est le tour du Joueur 1, False pour l'Ordinateur
        String currentJoueur = "";
        Boolean currentSymbole = true;
        int countTurn = 0;

        int startPlayer = rand.nextInt(0,2);
        if(startPlayer == 0)
        {
            joueur1Tour = true;
        }
        else
        {
            joueur1Tour = false;
        }

        while (true) 
        {
            // Simulation d'un tour de jeu
            if (joueur1Tour) 
            {
                currentJoueur = "Joueur 1";
            } 
            else 
            {
                currentJoueur = "Ordinateur";
            }

            System.out.println("Au tour de " + currentJoueur);
            printTabJeu(tabJeu);
            
            //Tour de jeu du joueur 1
            if (joueur1Tour)     
            {
                int ligne = scan.nextInt();
                int colonne = scan.nextInt();

                if (ligne < 0 || ligne >= 3 || colonne < 0 || colonne >= 3)
                {
                    System.out.println("Case invalide");
                }
                else if (!tabJeu[ligne][colonne].equals(" ")) 
                {
                    System.out.println("Case déjà prise");
                } 
                else 
                {
                    tabJeu[ligne][colonne] = printSymbole(currentSymbole);
                    joueur1Tour = false;
                    currentSymbole = !currentSymbole;
                    countTurn++;

                    if(verifVictoire(tabJeu, !currentSymbole))
                    {
                        printTabJeu(tabJeu);
                        System.out.println("Le joueur 1 a gagné !");
                        break;
                    }
                    if(countTurn == 9)
                    {
                        printTabJeu(tabJeu);
                        System.out.println("Match nul.");
                        break;
                    }
                }

            } 
            //Tour de jeu de l'ordinateur
            else 
            {
                int ligne;
                int colonne;
                do 
                {
                    ligne = rand.nextInt(0, 3);
                    colonne = rand.nextInt(0, 3);
                } 
                while (!tabJeu[ligne][colonne].equals(" "));

                tabJeu[ligne][colonne] = printSymbole(currentSymbole);
                joueur1Tour = true;
                currentSymbole = !currentSymbole;
                countTurn++;

                if(verifVictoire(tabJeu, !currentSymbole))
                {
                    printTabJeu(tabJeu);
                    System.out.println("L'ordinateur à gagné");
                    break;
                }
                if(countTurn == 9)
                {
                    printTabJeu(tabJeu);
                    System.out.println("Match nul.");
                }
                
            }
        }
    }

    // Fonction pour afficher le tableau de jeu
    private static void printTabJeu(String[][] tabJeu) 
    {
        for (int i = 0; i < tabJeu.length; i++) {
            System.out.println(" -------------");
            for (int j = 0; j < tabJeu[i].length; j++) {
                System.out.print(" | ");
                System.out.print(tabJeu[i][j]);
            }
            System.out.print(" | ");
            System.out.println();
        }
        System.out.println(" -------------");
    }

    private static String printSymbole(Boolean currentSymbole)
    {
        if(currentSymbole == true)
        {
            return "X";
        }
        else
        {
            return "O";
        }
    }

    private static boolean verifVictoire(String[][] tabJeu,boolean currentSymbole)
    {
        String symbole;
        if(currentSymbole == true)
        {
            symbole = "X";
        }
        else
        {
            symbole = "O";
        }

        for (int i = 0; i < 3; i++) {
            if (tabJeu[i][0].equals(symbole) && tabJeu[i][1].equals(symbole) && tabJeu[i][2].equals(symbole)) 
            {
                return true;
            }
        }
    
        for (int j = 0; j < 3; j++) {
            if (tabJeu[0][j].equals(symbole) && tabJeu[1][j].equals(symbole) && tabJeu[2][j].equals(symbole)) 
            {
                return true;
            }
        }
    
        if (tabJeu[0][0].equals(symbole) && tabJeu[1][1].equals(symbole) && tabJeu[2][2].equals(symbole)) 
        {
            return true;
        }
    
        if (tabJeu[0][2].equals(symbole) && tabJeu[1][1].equals(symbole) && tabJeu[2][0].equals(symbole)) 
        {
            return true;
        }
        return false;
    }
}
