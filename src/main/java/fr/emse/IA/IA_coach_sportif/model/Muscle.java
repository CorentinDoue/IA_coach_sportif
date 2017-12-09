
package fr.emse.IA.IA_coach_sportif.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@SuppressWarnings("serial")
public class Muscle {

    @Id
    @GeneratedValue
    private Long id;

    private String nom;



    @SuppressWarnings("unused")
    public Muscle() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}


