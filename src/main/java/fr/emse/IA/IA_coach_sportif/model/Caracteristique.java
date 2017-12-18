
package fr.emse.IA.IA_coach_sportif.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@SuppressWarnings("serial")
public class Caracteristique {

    private static final String CARACTERISTIQUES_GENERATOR = "CaracteriqtiquesGenerator";

    @Id
    @SequenceGenerator(name = CARACTERISTIQUES_GENERATOR, sequenceName = "CARACTERISTIQUES_SEQ", initialValue = 23, allocationSize = 1)
    @GeneratedValue(generator = CARACTERISTIQUES_GENERATOR)
    private Long id;

    private int taille;

    private int poids;

    @DateTimeFormat
    private Date date;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Muscles muscles;



    @SuppressWarnings("unused")
    public Caracteristique() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public int getPoids() {
        return poids;
    }

    public int getTaille() {
        return taille;
    }

    public Muscles getMuscles() {
        return muscles;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMuscles (Muscles muscles) {
        this.muscles = muscles;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

}


