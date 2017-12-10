
package fr.emse.IA.IA_coach_sportif.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@SuppressWarnings("serial")
public class Caracteristique {

    @Id
    @GeneratedValue
    private Long id;

    private Long taille;

    private Long poids;

    private Long age;

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

    public Long getPoids() {
        return poids;
    }

    public Long getTaille() {
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

    public void setPoids(Long poids) {
        this.poids = poids;
    }

    public void setTaille(Long taille) {
        this.taille = taille;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}


