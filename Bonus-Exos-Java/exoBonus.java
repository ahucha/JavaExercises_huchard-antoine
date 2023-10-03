public class exoBonus
{
    public static void main(String[] args)
    {
        if(args.length != 1)
        {
            System.out.println("Il faut saisir en argument la taille du sapin");
            return;
        }
        int nbSapin = Integer.valueOf(args[0]);
        int nbLigneMax = 4;
        int nbEtoile = 1;

        int nombrelignetotal = 4;   //Le nombre de ligne d'étoile de tout le sapin
        int nombreAjoute = 5;
        if(nbSapin>1)
        {
            for (int i = 0; i < nbSapin-1; i++) //Permet de calculer le nombre de ligne total
            {
                nombrelignetotal += nombreAjoute;
                nombreAjoute++;
            }
        }
        else
        {
            nombrelignetotal = 4;   //nombre de ligne du sapin de taille 1
        }

        int nbEtoileFinale = 1;                     //Le nombre d'étoile sur la base du sapin final
        for(int i=0; i < nombrelignetotal; i++)  //Permet de calculer le nombre d'étoile sur la base du sapin final
        {
            nbEtoileFinale+=2;
        }
        if(nbSapin>1)
        {
            nbEtoileFinale = nbEtoileFinale - nbSapin*4 +2;
        }
        else
        {
            nbEtoileFinale = 7;     //Nombre d'étoile de la base du sapin de taille 1
        }

        // System.out.println("nb Ligne " + nombrelignetotal);
        // System.out.println("nb etoile : " + nbEtoileFinale);
        // System.out.println("nb Espace" + nbEtoileFinale / 2);
        
        int nbEspace = nbEtoileFinale / 2;

        //Print du sapin
        for(int i =1; i <= nbSapin; i++)
        {
            for(int j = 1; j <= nbLigneMax; j++)
            {
                for(int k=1; k<= nbEspace; k++) 
                {
                    System.out.print(" ");
                }
                for(int k=1; k<=nbEtoile; k++)
                {
                    System.out.print("*");
                }
                nbEspace--;
                nbEtoile=nbEtoile+2;
                System.out.println();
            }
            nbLigneMax ++;          //Entre chaque sapin on augmente le nombre d'espace de 2 et on enleve 4 etoile
            nbEtoile = nbEtoile-4;
            nbEspace = nbEspace +2;
        }

        //Print du tronc
        int troncLargeur = nbSapin;
        int troncHauteur = nbSapin;

        for (int i = 0; i < troncHauteur; i++) 
        {
            for (int j = 0; j < nbEtoileFinale / 2 - troncLargeur / 2; j++) 
            {
                System.out.print(" ");
            }
            for (int j = 0; j < troncLargeur; j++) 
            {
                System.out.print("|");
            }
            System.out.println();
        }
    }
}


