package org.example;
import java.util.Scanner;


import static org.example.BaseGestion.*;

public class IHM {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        startMenu();
    }

    public static void startMenu(){
        while(true)
        {
            afficheMenuBase();
            String choix = scanner.nextLine();

            switch (choix){
                case "1" -> addEtudiant();
                case "2" -> listeEtudiant();
                case "3" -> listeEtudiantClass();
                case "4" -> remove1Etudiant();
                case "0" -> {
                    System.out.println("Au revoir !!!");
                    return; // (termine l'application)
                }
                default -> System.out.println("Choix invalide !!!!");
            }

        }
    }

    public static void afficheMenuBase(){
        System.out.println("##### GESTION ETUDIANT #######");
        System.out.println();
        System.out.println("1) Ajoutez un étudiant");
        System.out.println("2) Affichez tous les étudiants");
        System.out.println("3) Affichez les étudiant d'une Classe");
        System.out.println("4) Supprimez un étudiant");
        System.out.println("0) Quitter");
        System.out.println();
        System.out.print("Faite votre choix : ");
    }

}