package org.example.HanenAllouche_LSI3_SOA_TP6.web;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.HanenAllouche_LSI3_SOA_TP6.entities.Compte;
import org.example.HanenAllouche_LSI3_SOA_TP6.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // indique qu'une classe est un composant géré par Spring et elle sera automatiquement
// détectée et enregistrée en tant que beans
@Path("/banque")
public class CompteRestJAXSAPI {
    @Autowired //utilisée pour injecter automatiquement une dépendance dans un composant , dans notre cas
    // injecter CompteRepository dans CompteRestJaxRSAPI pour effectuer les opérations de gestion des comptes.
    private CompteRepository compteRepository;
    @Path("/comptes") // lorsque l'application JAX-RS reçoit une requête HTTP avec un chemin d'URI
    // correspondant à "/compte", elle dirigera la requête vers la methode compteList()
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) //on l'a utilisé pour indiquer que la methode
    // "compteList" produit des réponses au format JSON et XML.
    @Transactional // indique à Spring que la méthode annotée doit être exécutée dans un contexte transactionnel.
    public List<Compte> compteList(){
        return compteRepository.findAll();
    }//compteList() pour la recuperation de  la liste des comptes bancaires au format JSON.
    @Path("/comptes/{id}") // lorsque l'application JAX-RS reçoit une requête HTTP avec un chemin d'URI
    // correspondant à "/compte/{id}", elle dirigera la requête vers la methode getone()
    @GET
    @Produces({MediaType.APPLICATION_JSON}) //on l'a utilisé pour indiquer que la methode "getone" produit des réponses
    // au format JSON.
    public Compte getone(@PathParam(value="id") Long id){
        return compteRepository.findById(id).get();
    }
    // on a utilisé getOne(@PathParam("id") Long id) pour récupérer un compte spécifique par son identifiant.
    // @PathParam("id")permet de récupérer la valeur dynamique id à partir de l'URI et de la passer en tant que paramètre à la méthode.
    @Path("/comptes")
    @POST
    @Produces({MediaType.APPLICATION_JSON}) //on l'a utilisé pour indiquer que la methode "save" produit des réponses
    // au format JSON.
    @Consumes({MediaType.APPLICATION_JSON}) // on l'a utilisé pour indiquer que la methode "save" consomme des données
    // JSON en tant que charge utile de la requête.
    public Compte save(Compte compte){
        return compteRepository.save(compte);
    }
    // on a utilisé save(Compte compte) pour créer un nouveau compte en utilisant les données fournies.
    @Path("/comptes/{id}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON}) //on l'a utilisé pour indiquer que la methode "update" produit des réponses
    // au format JSON.
    public Compte update(Compte compte ,@PathParam("id")Long id){
        compte.setId(id);
        return compteRepository.save(compte);
    }//on a utilsé update(Compte compte, @PathParam("id") Long id) pour mettre à jour un compte existant
    // en utilisant les données fournies.
    @Path("/comptes/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON}) //on l'a utilisé pour indiquer que la methode "delete" produit des réponses
    // au format JSON.
    public void delete (@PathParam("id")Long id){
        compteRepository.deleteById(id);
    }
    //delete(@PathParam("id") Long id) pour supprimer un compte en fonction de son identifiant id
}
