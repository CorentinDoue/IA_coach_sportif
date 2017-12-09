
package fr.emse.IA.IA_coach_sportif.model;

import javax.persistence.*;

@Entity
@SuppressWarnings("serial")
public class Note_muscle {

    @Id
    @GeneratedValue
    private Long id;

    private int note;

    @ManyToOne
    private Muscle muscle;



    @SuppressWarnings("unused")
    public Note_muscle() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public Muscle getMuscle() {
        return muscle;
    }

    public void setMuscle(Muscle muscle) {
        this.muscle = muscle;
    }
}


