package org.example.HanenAllouche_LSI3_SOA_TP6.web;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //on l'a utilisé pour indiquer que la classe Myconfig joue le rôle de configuration dans l'application.
public class MyConfig {
    @Bean // c'est une annotation de Spring indique que la methode resourceConfig retourne une jersyServlet
// qui doit être géré par le conteneur Spring, et cet objet  doit être enregistré en tant que bean.
  public ResourceConfig resourceConfig(){
      ResourceConfig jersyServlet = new ResourceConfig();
      jersyServlet.register(CompteRestJAXSAPI.class);
      return jersyServlet;

  }
}
