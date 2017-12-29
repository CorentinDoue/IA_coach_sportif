package fr.emse.IA.IA_coach_sportif.web.seance;

import fr.emse.IA.IA_coach_sportif.model.Materiels;

public final class MaterielsDTO {
    private final Long id;
    private final boolean halteres;
    private final boolean barre;
    private final boolean barreEZ;
    private final boolean barreTraction;
    private final boolean elastique;
    private final boolean poulie;
    private final boolean cordeSaute;

    public MaterielsDTO(Materiels materiels) {
        this.id = materiels.getId();
        this.cordeSaute = materiels.isCordeSaute();
        this.barre = materiels.isBarre();
        this.barreEZ = materiels.isBarreEZ();
        this.barreTraction = materiels.isBarreTraction();
        this.elastique = materiels.isElastique();
        this.halteres = materiels.isHalteres();
        this.poulie = materiels.isPoulie();
    }

    public Long getId() {
        return id;
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
