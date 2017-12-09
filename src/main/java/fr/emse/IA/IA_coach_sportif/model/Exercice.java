package fr.emse.IA.IA_coach_sportif.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Exercice {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Note_muscle> muscles;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Materiel> materiels;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Description> description;

    private int difficulte;

    private boolean repetition;


    public Exercice(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMuscles(List<Note_muscle> muscles) {
        this.muscles = muscles;
    }

    public List<Note_muscle> getMuscles() {
        return muscles;
    }

    public String getName() {
        return name;
    }

    public int getDifficulte() {
        return difficulte;
    }

    public List<Materiel> getMateriels() {
        return materiels;
    }

    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }

    public void setMateriels(List<Materiel> materiels) {
        this.materiels = materiels;
    }

    public void setName(String name) {
        this.name = name;
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
}
