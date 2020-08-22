package com.cooly.jpaonetomany.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


    @Entity
    @Table(name = "Banque")
    public class Banque implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom_banque;


    public String getNom_banque() {
      return nom_banque;
    }

    public void setNom_banque(String nom_banque) {
      this.nom_banque = nom_banque;
    }

    public Banque() {
    }

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

  }
