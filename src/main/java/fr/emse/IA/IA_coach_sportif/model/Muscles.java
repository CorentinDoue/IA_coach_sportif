
package fr.emse.IA.IA_coach_sportif.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@SuppressWarnings("serial")
public class Muscles {

    @Id
    @GeneratedValue
    private Long id;
    private int biceps;
    private int	triceps;
    private int avantBras;
    private int trapezes;
    private int	dos;
    private int pectoraux;
    private int	abdominaux;
    private int	epaules;
    private int	quadriceps;
    private int	ischios;
    private int	fessiers;
    private int	cardio;




    @SuppressWarnings("unused")
    public Muscles() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAbdominaux() {
        return abdominaux;
    }

    public int getAvantBras() {
        return avantBras;
    }

    public int getBiceps() {
        return biceps;
    }

    public int getCardio() {
        return cardio;
    }

    public int getDos() {
        return dos;
    }

    public int getPectoraux() {
        return pectoraux;
    }

    public int getEpaules() {
        return epaules;
    }

    public int getFessiers() {
        return fessiers;
    }

    public int getIschios() {
        return ischios;
    }

    public int getQuadriceps() {
        return quadriceps;
    }

    public int getTrapezes() {
        return trapezes;
    }

    public int getTriceps() {
        return triceps;
    }

    public void setAbdominaux(int abdominaux) {
        this.abdominaux = abdominaux;
    }

    public void setAvantBras(int avantBras) {
        this.avantBras = avantBras;
    }

    public void setBiceps(int biceps) {
        this.biceps = biceps;
    }

    public void setCardio(int cardio) {
        this.cardio = cardio;
    }

    public void setDos(int dos) {
        this.dos = dos;
    }

    public void setEpaules(int epaules) {
        this.epaules = epaules;
    }

    public void setFessiers(int fessiers) {
        this.fessiers = fessiers;
    }

    public void setIschios(int ischios) {
        this.ischios = ischios;
    }

    public void setPectoraux(int pectoraux) {
        this.pectoraux = pectoraux;
    }

    public void setTrapezes(int trapezes) {
        this.trapezes = trapezes;
    }

    public void setQuadriceps(int quadriceps) {
        this.quadriceps = quadriceps;
    }

    public void setTriceps(int triceps) {
        this.triceps = triceps;
    }
}



