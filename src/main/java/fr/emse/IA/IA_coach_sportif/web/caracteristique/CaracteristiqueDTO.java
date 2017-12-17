package fr.emse.IA.IA_coach_sportif.web.caracteristique;

import fr.emse.IA.IA_coach_sportif.model.Caracteristique;
import fr.emse.IA.IA_coach_sportif.web.seance.MusclesDTO;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public final class CaracteristiqueDTO {
    private final Long id;
    private int taille;
    private int poids;
    @DateTimeFormat
    private Date date;
    private MusclesDTO muscles;


    public CaracteristiqueDTO(Caracteristique caracteristique) {
        this.id = caracteristique.getId();
        this.taille = caracteristique.getTaille();
        this.poids = caracteristique.getPoids();
        this.date = caracteristique.getDate();
        this.muscles = caracteristique.getMuscles()== null ? null: new MusclesDTO(caracteristique.getMuscles());
    }

    public Long getId() {
        return id;
    }


    public Date getDate() {
        return date;
    }

    public int getTaille() {
        return taille;
    }

    public int getPoids() {
        return poids;
    }

    public MusclesDTO getMuscles() {
        return muscles;
    }
}
