package UI;

import Model.Client;
import Service.ClientService;

import java.util.Scanner;

public class ClientUI {
    public static Scanner scanner = new Scanner(System.in);
    public static ClientService clientService = new ClientService();

    public static void clientMenu() {
        System.out.println("Welcome to the Client");
        System.out.println("------------------------");
        while (true){
            System.out.println("Please select an option");
            System.out.println("------------------------");
            System.out.println("1. Creez votre profil");
            System.out.println("2.votre profil");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch(option){
                case 1:
                    System.out.println("Creez votre profil");
                    Client client = getClientData();
                    clientService.addClient(client);
                    ClientUI.clientMenu();
                    break;
                case 2:
                    System.out.println("Votre profil");
                    String email = scanner.nextLine();
                    if (clientService.getClientByMail(email) != null){
                        System.out.println("Vos Informations : ");
                        System.out.println("-------------------------");
                        System.out.println(clientService.getClientByMail(email));
                    }else {
                        System.out.println("L'Email que vous avez saisie est incorrect ");
                    }










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
