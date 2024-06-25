package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Etudiant {
    private int id;
    private String nom = "toto";
    private String prenom;
    private int numero_classe;
    private LocalDate date_diplome;

}





