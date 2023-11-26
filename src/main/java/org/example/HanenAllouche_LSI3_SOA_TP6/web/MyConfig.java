package org.example.HanenAllouche_LSI3_SOA_TP6.web;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
  public ResourceConfig resourceConfig(){
      ResourceConfig jersyServlet = new ResourceConfig();
      jersyServlet.register(CompteRestJAXSAPI.class);
      return jersyServlet;

  }
}
