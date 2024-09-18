package Repository.Interface;

import Model.Client;

import java.util.List;

public interface ClientRepositoryInterface {
    public List<Client> clientList();
    public boolean addClient(Client client);
    public Client getClientByMail(String mail);
    public boolean updateClient(Client oldClient, Client newClient);
}
