import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Adresse;
import entities.Client;
import services.AdresseService;
import services.ClientService;

public class Views {
        public static void main(String[] args) throws Exception {
            ClientService clientService=new ClientService();
            AdresseService adresseService=new AdresseService();
            int choix;
            Scanner sc=new Scanner(System.in);
        
        do {
            System.out.println("1-Créer un Client");
            System.out.println("2-Lister les clients"); 
            System.out.println("3-Ajouter une adresse et lui associe un client"); 
            System.out.println("4-Lister les adresse en affichant le nom du client");
            System.out.println("5-Quitter"); 
             choix=sc.nextInt();
             sc.nextLine();
            switch (choix) {
                case 1:

                    System.out.println("Entrer l'ID");
                    int id=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Entrer le nom du client");
                    String nom=sc.nextLine(); 
                    System.out.println("Entrer le telephone");
                    String tel=sc.nextLine(); 
                    System.out.println("Entrer l'email");
                    String email=sc.nextLine(); 
                    Client cl=new Client();
                     cl.setId(id);
                     cl.setNomComplet(nom);
                     cl.setTelephone(tel);
                     cl.setEmail(email);
                     clientService.créerClient(cl);
                     
                    break;
                
                case 2:
                    List<Client> clients= clientService.listerClient();
                    for (Client client : clients) {
                        System.out.println("Id : "+client.getId() ); 
                        System.out.println("Nom complet  : "+client.getNomComplet() ); 
                        System.out.println("Telephone  : "+client.getTelephone()); 
                        System.out.println("Email  : "+client.getEmail()); 
                        System.out.println("--------------------");
                    }
                  
                    break; 
                    
                case 3:
                    // System.out.println("Voir Liste de clients :");
                    // clients = clientService.listerClient();
                    
                    System.out.println("Entrer l'ID");
                    int idA=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Entrer la ville");
                    String ville=sc.nextLine(); 
                    System.out.println("Entrer le quartier");
                    String quartier=sc.nextLine(); 
                    System.out.println("Entrer le numVilla");
                    String numVilla=sc.nextLine(); 

                    Adresse adresse=new Adresse();
                     adresse.setId(idA);
                     adresse.setVille(ville);
                     adresse.setQuartier(quartier);
                     adresse.setNumVilla(numVilla);
                    adresseService.ajouterAdresse(adresse);

                    


                   break;
                   
                case 4:
                    List<Adresse> adresses=adresseService.listerAdresse();
                    Client client=new Client();
                    for (Adresse adresse2 : adresses) {
                        System.out.println("Id : "+adresse2.getId()); 
                        System.out.println("Ville  : "+adresse2.getVille()); 
                        System.out.println("Quartier  : "+adresse2.getQuartier()); 
                        System.out.println("Numéro de Villa  : "+adresse2.getNumVilla()); 
                        System.out.println("Nom Client : "+ adresse2.getClient().getNomComplet());
                    }
                   
                   break; 
                    
            }
          } while (choix!=5);
    }
}
