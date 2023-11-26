package org.example.HanenAllouche_LSI3_SOA_TP6;
import org.example.HanenAllouche_LSI3_SOA_TP6.entities.Compte;
import org.example.HanenAllouche_LSI3_SOA_TP6.entities.EtatCompte;
import org.example.HanenAllouche_LSI3_SOA_TP6.entities.TypeCompte;
import org.example.HanenAllouche_LSI3_SOA_TP6.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Date;
@SpringBootApplication // est une annotation de Spring Boot qui est généralement utilisée
// pour marquer la classe principale d'une application Spring Boot.
public class HanenAlloucheLsi3SoaTp6Application {

	public static void main(String[] args) {
		SpringApplication.run(HanenAlloucheLsi3SoaTp6Application.class, args);
	}
@Bean // c'est une annotation de Spring utilisé pour indiquer que la methode CommandLineRunner retourne un args
// qui doit être géré par le conteneur Spring, et cet objet args doit être enregistré en tant que bean.
	public CommandLineRunner start(CompteRepository compterep) {
        return args -> {
			Compte compte1 = new Compte(null, 123, new Date(),TypeCompte.EPARGNE, EtatCompte.ACTIVE);
			Compte compte2 = new Compte(null, 145,new Date(),TypeCompte.EPARGNE,EtatCompte.ACTIVE);
			Compte compte3= new Compte(null,255,new Date(),TypeCompte.COURANT,EtatCompte.SUSPENDU);

			compterep.save(compte1); // permet de sauvegarder le compte1 dans l'entité en tant que ligne dans l'entité
			compterep.save(compte2);
			compterep.save(compte3);
			compterep.findAll().forEach(c->{ // je vais gerer les comptes comme etant une liste
				System.out.println(c.getSolde()); // je vais afficher les soldes des comptes
			});
		};
    }
}