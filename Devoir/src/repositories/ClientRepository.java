package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Client;

public class ClientRepository {
    
    public void insert(Client client){
        try  {
           // 1- Chargement du driver
           Class.forName("com.mysql.cj.jdbc.Driver");

          // 2- Connexion à la BD
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/devoir_java2","root", "");
          
               // 3- Exécuter une requête
          Statement statement = conn.createStatement();

          String sql=String.format("INSERT INTO `client` (`nomComplet`, `tel`, `email`)"+
          "VALUES ('%s', '%s', '%s')", 
          client.getNomComplet(), client.getTelephone(), client.getEmail());

          int nbreLigne = statement.executeUpdate(sql);
          
        } 
           catch (ClassNotFoundException e) {
               System.out.println("Echec du Driver");
           }
           catch(SQLException e){
               System.out.println("Echec de Connexion");
           }
    }

    public List<Client> selectAll(){
        List<Client> clients =new ArrayList<>();

        try  {
            // 1-2
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/devoir_java2","root", "");
            
            // 3- Exécuter ma requête
            Statement statement = conn.createStatement();
            String sql="select * from client";
            ResultSet rs = statement.executeQuery(sql); 
                
            while (rs.next()) {
              Client client =new Client();
              client.setNomComplet(rs.getString("nomComplet"));
              client.setTelephone(rs.getString("tel"));
              client.setEmail(rs.getString("email"));
              clients.add(client);
            } 
            statement.close();
            rs.close();
            conn.close();
        }

            catch (ClassNotFoundException e) {
                System.out.println("Echec du Driver");
            }
            catch(SQLException e){
                System.out.println("Echec de Connexion");
            }
            
            return clients;
        } 
  }




