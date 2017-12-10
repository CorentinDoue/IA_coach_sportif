package fr.emse.IA.IA_coach_sportif.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Materiels {

    @Id
    @GeneratedValue
    private Long id;
    private boolean halteres;
    private boolean	barre;
    private boolean barreEZ;
    private boolean	barreTraction;
    private boolean	elastique;
    private boolean	poulie;
    private boolean	autre;


    public Materiels(){}


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public boolean isAutre() {
        return autre;
    }

    public boolean isBarre() {
        return barre;
    }

    public boolean isBarreEZ() {
        return barreEZ;
    }

    public boolean isBarreTraction() {
        return barreTraction;
    }

    public boolean isElastique() {
        return elastique;
    }

    public boolean isHalteres() {
        return halteres;
    }

    public boolean isPoulie() {
        return poulie;
    }

    public void setAutre(boolean autre) {
        this.autre = autre;
    }

    public void setBarre(boolean barre) {
        this.barre = barre;
    }

    public void setBarreEZ(boolean barreEZ) {
        this.barreEZ = barreEZ;
    }

    public void setBarreTraction(boolean barreTraction) {
        this.barreTraction = barreTraction;
    }

    public void setElastique(boolean elastique) {
        this.elastique = elastique;
    }

    public void setHalteres(boolean halteres) {
        this.halteres = halteres;
    }

    public void setPoulie(boolean poulie) {
        this.poulie = poulie;
    }
}
