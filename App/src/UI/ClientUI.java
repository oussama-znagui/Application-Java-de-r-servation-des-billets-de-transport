package UI;

import Model.Client;

import java.util.Scanner;

public class ClientUI {
    public static Scanner scanner = new Scanner(System.in);

    public void clientMenu() {
        System.out.println("Welcome to the Client");
        System.out.println("------------------------");
        while (true){
            System.out.println("Please select an option");
            System.out.println("------------------------");
            System.out.println("1. Creez votre profil");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch(option){
                case 1:
                    Client client = getClientData();


            }



        }
    }




    public static Client getClientData() {
        System.out.println("Votre nom complet : ");
        String nom = scanner.nextLine();
        System.out.println("Votre email : ");
        String email = scanner.nextLine();
        System.out.println("Votre N° de telephone : ");
        String telephone = scanner.nextLine();
        return new Client(nom, email, telephone);
    }
}
