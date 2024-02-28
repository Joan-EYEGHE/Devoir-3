package services;

import java.util.List;

import entities.Adresse;
import repositories.AdresseRepository;

public class AdresseService {
    AdresseRepository adresseRepository;

    public  List<Adresse>listerAdresse(){
        return adresseRepository.selectAll();
    }

    public void ajouterAdresse(Adresse adresse){
        adresseRepository.insert(adresse);
    }
   
}
