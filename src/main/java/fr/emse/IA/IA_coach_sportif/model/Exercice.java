package fr.emse.IA.IA_coach_sportif.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Exercice {

    private static final String EXERCICE_GENERATOR = "ExerciceGenerator";

    @Id
    @SequenceGenerator(name = EXERCICE_GENERATOR, sequenceName = "EXERCICE_SEQ", initialValue = 61, allocationSize = 1)
    @GeneratedValue(generator = EXERCICE_GENERATOR)
    private Long id;

    private String nom;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Muscles muscles;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Materiels materiels;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Description> description;

    private int difficulte;

    private boolean repetition;

    private boolean poids;


    public Exercice(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Muscles getMuscles() {
        return muscles;
    }

    public void setMuscles(Muscles muscles) {
        this.muscles = muscles;
    }

    public String getNom() {
        return nom;
    }

    public int getDifficulte() {
        return difficulte;
    }

    public Materiels getMateriels() {
        return materiels;
    }

    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }

    public void setMateriels(Materiels materiels) {
        this.materiels = materiels;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Description> getDescription() {
        return description;
    }

    public void setDescription(List<Description> description) {
        this.description = description;
    }

    public void setRepetition(boolean repetition) {
        this.repetition = repetition;
    }

    public boolean isRepetition() {
        return repetition;
    }

    public boolean isPoids() {
        return poids;
    }

    public void setPoids(boolean poids) {
        this.poids = poids;
    }
}
