package UI;

import java.util.Scanner;

public class mainMenu {
    public static void menu(){
        System.out.println("Welcome to the main menu");
        System.out.println("---------------------");


      while (true){
          System.out.println("1. Gestion des parteners");
          System.out.println("2. Gestion des contrats");
          System.out.println("3. Gestion des tickets");
          System.out.println("4. Gestion des offres");
          System.out.println("\nVotre choix svp! : ");

          Scanner scanner = new Scanner(System.in);
          int option = scanner.nextInt();

          switch(option){
              case 1:
                  partnersMenu();
                  break;
              case 2:
                  contratsMenu();
                  break;
              case 3:
                  ticketsMenu();
                  break;
              case 4:
                  offresMenu();
                  break;
              default:
                  System.out.println("Invalid option");


          }
      }


    }

    public static void partnersMenu(){
        System.out.println("Welcome to the partners menu");
        System.out.println("---------------------");
        System.out.println("1. List des parteners");
        System.out.println("1. Ajouter un partener");
        System.out.println("2. Modifier un partener");
        System.out.println("3. Supprimer un partener");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();



    }

    public static void contratsMenu(){
        System.out.println("Welcome to the contrats menu");
        System.out.println("---------------------");
        System.out.println("1. List des contrats");
        System.out.println("1. Ajouter un contrat");
        System.out.println("2. Modifier un contrat");
        System.out.println("3. Supprimer un contrat");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
    }

    public static void ticketsMenu(){
        System.out.println("Welcome to the tickets menu");
        System.out.println("---------------------");
        System.out.println("1. List des tickets");
        System.out.println("1. Ajouter un ticket");
        System.out.println("2. Modifier un ticket");
        System.out.println("3. Supprimer un ticket");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
    }

    public static void offresMenu(){
        System.out.println("Welcome to the offres menu");
        System.out.println("---------------------");
        System.out.println("1. List des offres");
        System.out.println("1. Ajouter un offre");
        System.out.println("2. Modifier un offre");
        System.out.println("3. Supprimer un offre");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
    }
}
