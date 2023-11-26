package org.example.HanenAllouche_LSI3_SOA_TP6.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;
@Getter // générer automatiquement les méthodes getter
@Setter // générer automatiquement des méthodes seter
@ToString // générer automatiquement la méthode ToString()
@Entity //cette annotation permet de tranformer la classe Compte une entité dans la BD
@NoArgsConstructor // générer des constructeurs sans argument
@AllArgsConstructor // générer des constructeurs avec tous les arguments
public class Compte {
    @Id //c'est une annotation qui te donne un id a la classe qui va etre transformer en une entite dans la BD
    @GeneratedValue(strategy =GenerationType.IDENTITY) /* cette strategie permet d'incrementer le id automatiquement
    a chaque fois un compte sera ajouter*/
    private Long id;  //Identifiant du compte, généré automatiquement.
    private double solde; //Solde du compte
    private Date datecreation; //Date de création du compte.
    private TypeCompte type; //Type de compte, qui peut être soit COURANT soit EPARGNE.
    private EtatCompte etat; //Etat de compte, qui peut être CREE, ACTIVE, SUSPENDU, BLOQUE

}
