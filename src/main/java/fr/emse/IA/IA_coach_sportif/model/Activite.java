package fr.emse.IA.IA_coach_sportif.model;

import javax.persistence.*;

@Entity
public class Activite {

    @Id
    @GeneratedValue
    private Long id;

    private int repetition;

    private int temporisation;

    private int poids;

    private int note;

    @ManyToOne
    private Exercice exercice;

    public Activite(){}

    public void setNote(int note) {
        this.note = note;
    }

    public int getNote() {
        return note;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    public Exercice getExercice() {
        return exercice;
    }

    public int getRepetition() {
        return repetition;
    }

    public int getTemporisation() {
        return temporisation;
    }

    public void setExercice(Exercice exercice) {
        this.exercice = exercice;
    }

    public void setRepetition(int repetition) {
        this.repetition = repetition;
    }

    public void setTemporisation(int temporisation) {
        this.temporisation = temporisation;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public int getPoids() {
        return poids;
    }
}
