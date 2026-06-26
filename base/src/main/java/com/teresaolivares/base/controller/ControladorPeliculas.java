package com.teresaolivares.base.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorPeliculas {
  private static HashMap<String, String> listaPeliculas = new HashMap<String, String>();

  public ControladorPeliculas() {
    listaPeliculas.put("Winnie the Pooh", "Don Hall");
    listaPeliculas.put("El zorro y el sabueso", "Ted Berman");
    listaPeliculas.put("Tarzán", "Kevin Lima");
    listaPeliculas.put("Mulán", "Barry Cook");
    listaPeliculas.put("Oliver", "Kevin Lima");
    listaPeliculas.put("Big Hero 6", "Don Hall");
  }

  @GetMapping("/peliculas")
  public String obtenerTodasLasPeliculas() {
    StringBuilder titulo = new StringBuilder("Películas disponibles:<br/>");
    for (String pelicula : listaPeliculas.keySet()) {
      titulo.append("- " + pelicula + "<br/>");
    }
    return titulo.toString();
  }

  @GetMapping("/peliculas/{nombre}")

  public String obtenerPeliculaPorNombre(@PathVariable String nombre) {
    String director = listaPeliculas.get(nombre);
    if (director != null) {
      return "La pelicula\"" + nombre + "\" fue dirigida por " + director;
    } else {
      return "«La película no se encuentra en nuestra lista.»";
    }
  }

  @GetMapping("/peliculas/director/{nombre}")

  public String obtenerPeliculasPorDirector(@PathVariable String nombre) {
    StringBuilder dire = new StringBuilder("Peliculas dirigidas por " + nombre + ":<br/>");
    boolean encontrado = false;
    for (String pelicula : listaPeliculas.keySet()) {
      String director = listaPeliculas.get(pelicula);
      if (director.equalsIgnoreCase(nombre)) {
        dire.append("- " + pelicula + "<br/>");
        encontrado = true;
      }
    }
    if (encontrado) {
      return dire.toString();
    } else {
      return "«No contamos con películas con ese director en nuestra lista.»";
    }

  }

}
