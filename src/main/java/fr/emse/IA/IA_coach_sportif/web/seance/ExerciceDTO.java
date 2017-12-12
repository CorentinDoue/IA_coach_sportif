package fr.emse.IA.IA_coach_sportif.web.seance;

import fr.emse.IA.IA_coach_sportif.model.Exercice;

import java.util.List;
import java.util.stream.Collectors;

public final class ExerciceDTO {
    private final Long id;

    private final String nom;

    private final MusclesDTO muscles;

    private final MaterielsDTO materiels;

    private final List<DescriptionDTO> description;

    private final int difficulte;

    private final boolean repetition;

    private final boolean poids;

    public ExerciceDTO(Exercice exercice) {
        this.id = exercice.getId();
        this.nom = exercice.getNom();
        this.repetition = exercice.isRepetition();
        this.poids = exercice.isPoids();
        this.difficulte = exercice.getDifficulte();
        this.muscles = exercice.getMuscles() == null ? null : new MusclesDTO(exercice.getMuscles());
        this.materiels = exercice.getMateriels() == null ? null : new MaterielsDTO(exercice.getMateriels());
        this.description = exercice.getDescription()== null ? null: exercice.getDescription().stream().map(DescriptionDTO::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public List<DescriptionDTO> getDescription() {
        return description;
    }

    public boolean isPoids() {
        return poids;
    }

    public boolean isRepetition() {
        return repetition;
    }

    public int getDifficulte() {
        return difficulte;
    }

    public String getNom() {
        return nom;
    }

    public MaterielsDTO getMateriels() {
        return materiels;
    }

    public MusclesDTO getMuscles() {
        return muscles;
    }
}
