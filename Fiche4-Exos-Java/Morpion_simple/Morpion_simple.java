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
        boolean joueur1Tour = quiCommence(rand);
        String currentJoueur = "";
        Boolean currentSymbole = true;
        int countTurn = 0;

        // Simulation d'un tour de jeu
        while (true) 
        {
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
            if(joueur1Tour)     
            {
                joueur1Tour(tabJeu, scan, currentSymbole);
                joueur1Tour = false;
            } 
            //Tour de jeu de l'ordinateur
            else 
            {
                ordinateurTour(tabJeu, rand, currentSymbole);
                joueur1Tour = true;         
            }
            countTurn++;

            //Vérification de la victoire
            if(verifVictoire(tabJeu, currentSymbole))
            {
                printTabJeu(tabJeu);
                System.out.println(currentJoueur + " à gagné");
                break;
            }

            //Vérification de match nul
            if(countTurn == 9)
            {
                printTabJeu(tabJeu);
                System.out.println("Match nul.");
                break;
            }

            currentSymbole = !currentSymbole;
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

    //Fonction pour savoir qui commence 0 => Joueur 1, 1=> Ordinateur
    private static boolean quiCommence(Random rand)
    {
        int startPlayer = rand.nextInt(0,2);
        return startPlayer==0;
    }

    //Fonction qui simule le tour d'un joueur
    private static void joueur1Tour(String[][] tabJeu, Scanner scan, boolean currentSymbole)
    {
        int ligne = -1;
        int colonne = -1;

        while (ligne < 0 || ligne >= 3 || colonne < 0 || colonne >= 3 || !tabJeu[ligne][colonne].equals(" ")) {
            System.out.println("Veuillez entrer la ligne et la colonne (0, 1 ou 2) séparées par un espace : ");
            ligne = scan.nextInt();
            colonne = scan.nextInt();
    
            if (ligne < 0 || ligne >= 3 || colonne < 0 || colonne >= 3) {
                System.out.println("Case invalide");
            } else if (!tabJeu[ligne][colonne].equals(" ")) {
                System.out.println("Case déjà prise");
            }
        }
    
        tabJeu[ligne][colonne] = printSymbole(currentSymbole);
    }

    //Fonction qui simule le tour de l'ordinateur
    private static void ordinateurTour(String[][] tabJeu,Random rand ,boolean currentSymbole)
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

    //Vérification des conditions de victoire
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
