package fr.emse.IA.IA_coach_sportif.web.users;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CaracteristiqueCommandDTO {

    private final Long taille;

    private final Long poids;

    private final Long age;

    @JsonCreator
    public CaracteristiqueCommandDTO (@JsonProperty("taille") Long taille,
                                      @JsonProperty("poids") Long poids,
                                      @JsonProperty("age") Long age){
        this.age = age;
        this.poids = poids;
        this.taille = taille;
    }

    public Long getAge() {
        return age;
    }

    public Long getPoids() {
        return poids;
    }

    public Long getTaille() {
        return taille;
    }
}
