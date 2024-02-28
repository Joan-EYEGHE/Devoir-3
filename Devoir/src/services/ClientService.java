package services;

import java.util.List;

import entities.Client;
import repositories.ClientRepository;

public class ClientService {

    ClientRepository clientRepository;

    public  List<Client>listerClient(){
        return clientRepository.selectAll();
    }

    public void créerClient(Client client){
        clientRepository.insert(client);
    }


}
