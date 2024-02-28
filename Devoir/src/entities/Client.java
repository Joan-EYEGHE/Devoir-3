package entities;

import java.util.List;

public class Client {
    private int id; 
    private String nomComplet; 
    private String telephone; 
    private String email;
    private List<Adresse> adresse;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }
    public List<Adresse> getAdresse() {
        return adresse;
    }
    public void setAdresse(List<Adresse> adresse) {
        this.adresse = adresse;
    }
}
