
package fr.emse.IA.IA_coach_sportif.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@SuppressWarnings("serial")
public class Caracteristique {

    @Id
    @GeneratedValue
    private Long id;

    private Long taille;

    private Long poids;

    @DateTimeFormat
    private Date date;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Note_muscle> muscles;



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

    public Long getPoids() {
        return poids;
    }

    public Long getTaille() {
        return taille;
    }

    public List<Note_muscle> getMuscles() {
        return muscles;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMuscles (List<Note_muscle> muscles) {
        this.muscles = muscles;
    }

    public void setPoids(Long poids) {
        this.poids = poids;
    }

    public void setTaille(Long taille) {
        this.taille = taille;
    }
}


