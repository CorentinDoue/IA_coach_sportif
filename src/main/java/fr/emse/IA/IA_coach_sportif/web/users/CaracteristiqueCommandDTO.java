package fr.emse.IA.IA_coach_sportif.web.users;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CaracteristiqueCommandDTO {

    private final int taille;

    private final int poids;

    @JsonCreator
    public CaracteristiqueCommandDTO (@JsonProperty("taille") int taille,
                                      @JsonProperty("poids") int poids
                                      ){
        this.poids = poids;
        this.taille = taille;
    }



    public int getPoids() {
        return poids;
    }

    public int getTaille() {
        return taille;
    }
}
