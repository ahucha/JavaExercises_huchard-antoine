package Morpion_swing;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Morpion_swing 
{
    public static void main(String[] args) 
    {
        String[][] tabJeu = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
        Random rand = new Random();
        final boolean[] joueur1Tour = {quiCommence(rand)};
        final boolean[] currentSymbole = {true};
        final int[] countTurn = {0};

        JFrame frame = new JFrame("Morpion Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.getContentPane().setBackground(Color.BLACK);

        JPanel panel = new JPanel(new GridLayout(3, 3));
        frame.add(panel, BorderLayout.CENTER);

        JLabel label = new JLabel("C'est au tour du " + printLabel(joueur1Tour, currentSymbole) + " de jouer");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setForeground(Color.white);
        frame.add(label, BorderLayout.NORTH);

        JButton[][] boutons = new JButton[3][3];
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                final int finalI = i;
                final int finalJ = j;
                boutons[finalI][finalJ] = new JButton();
                panel.add(boutons[i][j]);
                boutons[finalI][finalJ].setFont(new Font("Arial", Font.PLAIN, 70));
                boutons[finalI][finalJ].setBackground(Color.BLACK);
                boutons[finalI][finalJ].addActionListener(new ActionListener() 
                {
                    public void actionPerformed(ActionEvent e) 
                    {
                        JButton boutonClique = (JButton) e.getSource();
                        countTurn[0]++;

                        boutons[finalI][finalJ].setText(printSymbole(currentSymbole[0]));
                        boutonClique.setForeground(Color.BLUE);
                        tabJeu[finalI][finalJ] = printSymbole(currentSymbole[0]);
                        boutons[finalI][finalJ].setEnabled(false);

                        if(verifVictoire(tabJeu,currentSymbole))
                        {
                            JOptionPane.showMessageDialog(null,  printLabel(joueur1Tour, currentSymbole) + " à gagné !");
                            resetGame(tabJeu, joueur1Tour, currentSymbole, countTurn, boutons, label);
                        }
                        if (countTurn[0] == 9 && !verifVictoire(tabJeu, currentSymbole))
                        {
                            JOptionPane.showMessageDialog(null, "Match nul.");
                            resetGame(tabJeu, joueur1Tour, currentSymbole, countTurn, boutons, label);
                        }
                        joueur1Tour[0] = !joueur1Tour[0];
                        currentSymbole[0] = !currentSymbole[0];
                        label.setText("C'est au tour du " + printLabel(joueur1Tour, currentSymbole) + " de jouer");
                    }
                });
            }
            JButton resetButton = new JButton("Réinitialiser");
            frame.add(resetButton, BorderLayout.SOUTH);
    
            resetButton.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    resetGame(tabJeu, joueur1Tour, currentSymbole, countTurn, boutons, label);
                }
            });
        }
        frame.setVisible(true);
    }


    //-------------------------------------------------------------------------------------FONCTIONS---------------------------------------------------------------------------------\\

    private static boolean quiCommence(Random rand) 
    {
        int startPlayer = rand.nextInt(0, 2);
        return startPlayer == 0;
    }

    private static String printSymbole(boolean currentSymbole) 
    {
        return currentSymbole ? "X" : "O";
    }

    private static String printLabel(boolean[] joueur1Tour, boolean[] currentSymbole) 
    {
        if(joueur1Tour[0]) 
        {
            return "Joueur 1 (" + printSymbole(currentSymbole[0]) + ")";
        } 
        else 
        {
            return "Joueur 2 (" + printSymbole(currentSymbole[0]) + ")";
        }
    }
    //Vérification des conditions de victoire
    private static boolean verifVictoire(String[][] tabJeu,boolean[] currentSymbole)
    {
        String symbole;
        if(currentSymbole[0] == true)
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

    private static void resetGame(String[][] tabJeu, boolean[] joueur1Tour, boolean[] currentSymbole, int[] countTurn, JButton[][] boutons, JLabel label) 
    {
        joueur1Tour[0] = quiCommence(new Random());
        currentSymbole[0] = true;
        countTurn[0] = 0;
    
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                boutons[i][j].setText("");
                boutons[i][j].setEnabled(true);
            }
        }
        if (joueur1Tour[0]) 
        {
            label.setText("C'est au tour du Joueur 1 (X) de jouer");
        } 
        else 
        {
            label.setText("C'est au tour du Joueur 2 (O) de jouer");
        }
    }
}
