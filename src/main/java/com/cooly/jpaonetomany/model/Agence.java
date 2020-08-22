package com.cooly.jpaonetomany.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

    @Entity
    @Table(name = "Agence")
    public class Agence implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_agence;

    private String libelle;


    @ManyToOne
    @JoinColumn(name = "banque_id", nullable = false)
    @JsonBackReference
    private Banque Banque;

    public Banque getBanque() {
      return Banque;
    }

    public void setBanque(Banque banque) {
      Banque = banque;
    }

      public Agence() {
    }


      public String getLibelle() {
        return libelle;
      }

      public void setLibelle(String libelle) {
        this.libelle = libelle;
      }

      public Long getId_agence() {
        return id_agence;
      }

      public void setId_agence(Long id_agence) {
        this.id_agence = id_agence;
      }

    }
