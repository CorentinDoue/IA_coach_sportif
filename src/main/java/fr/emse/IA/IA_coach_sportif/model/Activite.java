package fr.emse.IA.IA_coach_sportif.model;

import javax.persistence.*;

@Entity
public class Activite {

    private static final String ACTIVITE_GENERATOR = "ActiviteGenerator";

    @Id
    @SequenceGenerator(name = ACTIVITE_GENERATOR, sequenceName = "ACTIVITE_SEQ", initialValue = 2, allocationSize = 1)
    @GeneratedValue(generator = ACTIVITE_GENERATOR)
    private Long id;

    private int repetition;

    private int temporisation;

    private int poids;

    private int note;

    @ManyToOne
    private Exercice exercice;

    public Activite() {

    }

    public Activite copy(){
        Activite activite = new Activite();
        activite.setExercice(this.getExercice());
        activite.setTemporisation(this.getTemporisation());
        activite.setPoids(this.getPoids());
        activite.setRepetition(this.getRepetition());
        return activite;
    }

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
