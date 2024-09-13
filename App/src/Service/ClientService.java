package Service;

import Model.Client;
import Repository.ClientRepository;

public class ClientService {
    public static ClientRepository clientRepository = new ClientRepository();


    public boolean addClient(Client client) {
        if(clientRepository.getClientByMail(client.getEmail()) != null) {
            System.out.println("Client with email " + client.getEmail() + " already exists");
            return false;

        }else{
            return clientRepository.addClient(client);
        }

    }


    public Client getClientByMail(String email) {
        if(clientRepository.getClientByMail(email) != null) {
            return clientRepository.getClientByMail(email);
        }
        else {
                System.out.println("Client with email " + email + " does not exist");
            return null;
        }
    }
}

