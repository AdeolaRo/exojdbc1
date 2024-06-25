package org.example;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseGestion {
    public static void ajouterEtudiant(Etudiant etudiant){

        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=exojdbc1";
        String username = "postgres";
        String password = "abdel";

        Connection connection;

        try{
            connection = DriverManager.getConnection(url, username, password);
            if (connection !=null){
                System.out.println("La connection à réussie !");
            }else {System.out.println("La connection à échouée");}


                     etudiant = Etudiant.builder()
                    .nom(etudiant.getNom())
                    .prenom(etudiant.getPrenom())
                    .numero_classe(etudiant.getNumero_classe())
                    .date_diplome(etudiant.getDate_diplome())
                    .build();


            String request1 = "insert into etudiant (nom, prenom, numero_classe, date_diplome) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(request1);
            preparedStatement.setString(1, etudiant.getNom());
            preparedStatement.setString(2, etudiant.getPrenom());
            preparedStatement.setInt(3, etudiant.getNumero_classe());
            preparedStatement.setDate(4, Date.valueOf(etudiant.getDate_diplome()));

            int nbrRow = preparedStatement.executeUpdate();
            if (nbrRow == 1){
                System.out.println("Etudiant ajouté");
            }else System.out.println("Erreur lors de l'ajout");



        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

  }


    public static void listeEtudiant(){

        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=exojdbc1";
        String username = "postgres";
        String password = "abdel";

        Connection connection;
        try{
            connection = DriverManager.getConnection(url, username, password);
            if (connection !=null){
                System.out.println("La connection à réussie !");
            }else {System.out.println("La connection à échouée");}

            String request = "SELECT * FROM etudiant";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(request);

            List<Etudiant> etudiants = new ArrayList<>();
            while(resultSet.next()){
               etudiants.add(Etudiant.builder()

                        .id(resultSet.getInt("id"))
                        .nom(resultSet.getString("nom"))
                        .prenom(resultSet.getString("prenom"))
                        .numero_classe(resultSet.getInt("numero_classe"))
                        .date_diplome(resultSet.getDate("date_diplome").toLocalDate())
                        .build());
            }
            System.out.println(etudiants);

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void remove1Etudiant(){

        Scanner sc = new Scanner(System.in);
        int identifiant;

        System.out.println("Veuillez fournir l'id de létudiant à supprimer : ");
         identifiant = sc.nextInt();

        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=exojdbc1";
        String username = "postgres";
        String password = "abdel";

        Connection connection;
        try{
            connection = DriverManager.getConnection(url, username, password);
            if (connection !=null){
                System.out.println("La connection à réussie !");
            }else {System.out.println("La connection à échouée");}

            String request = "DELETE FROM etudiant WHERE id ="+identifiant;

            Statement statement = connection.createStatement();
            //ResultSet resultSet = statement.executeQuery(request);

            int nbrRow = statement.executeUpdate(request);
            if (nbrRow != 0){
                System.out.println("Etudiant Supprimé");
            }else System.out.println("Erreur lors de la suppression");



        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void listeEtudiantClass(){

        Scanner sc = new Scanner(System.in);
        int numeroClass;

        System.out.println("Veuillez fournir le numéro de la Classe : ");
        numeroClass = sc.nextInt();

        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=exojdbc1";
        String username = "postgres";
        String password = "abdel";

        Connection connection;
        try{
            connection = DriverManager.getConnection(url, username, password);
            if (connection !=null){
                System.out.println("La connection à réussie !");
            }else {System.out.println("La connection à échouée");}

            String request = "SELECT * FROM etudiant WHERE numero_classe ="+numeroClass;

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(request);

            List<Etudiant> etudiants = new ArrayList<>();
            while(resultSet.next()){
                etudiants.add(Etudiant.builder()

                        .id(resultSet.getInt("id"))
                        .nom(resultSet.getString("nom"))
                        .prenom(resultSet.getString("prenom"))
                        .numero_classe(resultSet.getInt("numero_classe"))
                        .date_diplome(resultSet.getDate("date_diplome").toLocalDate())
                        .build());
            }
            System.out.println(etudiants);

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void addEtudiant(){

        Scanner sc = new Scanner(System.in);
        var etudiant = new Etudiant();

        System.out.println("Ajouter un nom étudiant : ");
        etudiant.setNom(sc.nextLine());

        System.out.println("Ajouter un prénom étudiant : ");
        etudiant.setPrenom(sc.nextLine());

        System.out.println("Ajouter un numéro de Classe : ");
        etudiant.setNumero_classe(sc.nextInt());
        sc.nextLine();

        System.out.println("Ajouter une date de diplôme : ");
        etudiant.setDate_diplome(LocalDate.parse(sc.nextLine()));

        BaseGestion.ajouterEtudiant(etudiant);
    }

}