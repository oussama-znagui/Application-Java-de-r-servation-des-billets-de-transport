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
                        System.out.println("------------------------");
                        System.out.println("Vous voulez Modifier Vos Informations(y/n) : ");
                        char c = scanner.next().charAt(0);
                        scanner.nextLine();
                        switch (c){
                            case 'y':
                                updateClientMenu(clientService.getClientByMail(email));
                                ClientUI.clientMenu();
                                break;
                            case 'n':
                                ClientUI.clientMenu();
                                break;


                        }

                    }else {
                        System.out.println("L'Email que vous avez saisie est incorrect ");
                    }
            }

        }
    }

    public static void updateClientMenu(Client client) {
        Client newClient = getClientData();
        clientService.updateClient(client, newClient);
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



//    String email = null;
//    int i = 0;
//        do {
//        if (i == 0){
//            email = scanner.nextLine();
//        }else {
//            System.out.println("l'email que vous avez saisie exist deja ");
//            System.out.println("Autre email svp : ");
//            email = scanner.nextLine();
//        }
//        i++;
//    }while (clientService.getClientByMail(email) != null);

}
