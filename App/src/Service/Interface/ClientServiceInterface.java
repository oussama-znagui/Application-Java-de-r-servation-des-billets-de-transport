package Service.Interface;

import Model.Client;

public interface ClientServiceInterface {

    public boolean updateClient(Client client, Client newClient);
    public Client getClientByMail(String email);
    public boolean addClient(Client client);

}
