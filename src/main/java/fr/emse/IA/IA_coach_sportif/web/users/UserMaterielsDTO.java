package fr.emse.IA.IA_coach_sportif.web.users;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class UserMaterielsDTO {

    private final boolean halteres;
    private final boolean barre;
    private final boolean barreEZ;
    private final boolean barreTraction;
    private final boolean elastique;
    private final boolean poulie;
    private final boolean cordeSaute;

    @JsonCreator
    public UserMaterielsDTO(@JsonProperty("halteres") boolean halteres,
                            @JsonProperty("barre") boolean barre,
                            @JsonProperty("barreEZ") boolean barreEZ,
                            @JsonProperty("barreTraction") boolean barreTraction,
                            @JsonProperty("elastique") boolean elastique,
                            @JsonProperty("poulie") boolean poulie,
                            @JsonProperty("cordeSaute") boolean cordeSaute
                            ) {
        this.halteres = halteres;
        this.barre = barre;
        this.barreEZ = barreEZ;
        this.barreTraction = barreTraction;
        this.elastique = elastique;
        this.poulie = poulie;
        this.cordeSaute = cordeSaute;
    }



    public boolean isPoulie() {
        return poulie;
    }

    public boolean isHalteres() {
        return halteres;
    }

    public boolean isElastique() {
        return elastique;
    }

    public boolean isBarreTraction() {
        return barreTraction;
    }

    public boolean isBarreEZ() {
        return barreEZ;
    }

    public boolean isBarre() {
        return barre;
    }

    public boolean isCordeSaute() {
        return cordeSaute;
    }
}
