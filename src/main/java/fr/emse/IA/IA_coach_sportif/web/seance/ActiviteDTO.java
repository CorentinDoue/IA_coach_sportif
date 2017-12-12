package fr.emse.IA.IA_coach_sportif.web.seance;

import fr.emse.IA.IA_coach_sportif.model.Activite;

public final class ActiviteDTO {
    private final Long id;

    private final int repetition;

    private final int temporisation;

    private final int poids;

    private final int note;

    private final ExerciceDTO exercice;

    public ActiviteDTO(Activite activite) {
        this.id = activite.getId();
        this.note = activite.getNote();
        this.repetition = activite.getRepetition();
        this.temporisation = activite.getTemporisation();
        this.poids = activite.getPoids();
        this.exercice = activite.getExercice() == null ? null : new ExerciceDTO(activite.getExercice());
    }

    public Long getId() {
        return id;
    }

    public int getNote() {
        return note;
    }

    public int getPoids() {
        return poids;
    }

    public ExerciceDTO getExercice() {
        return exercice;
    }

    public int getRepetition() {
        return repetition;
    }

    public int getTemporisation() {
        return temporisation;
    }
}
