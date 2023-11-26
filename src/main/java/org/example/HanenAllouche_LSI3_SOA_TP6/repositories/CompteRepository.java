package org.example.HanenAllouche_LSI3_SOA_TP6.repositories;

import org.example.HanenAllouche_LSI3_SOA_TP6.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Long> { /* Compte c'est la classe et Long c'est le
    le type de l'ID (Long est une classe primitive)  */
}
