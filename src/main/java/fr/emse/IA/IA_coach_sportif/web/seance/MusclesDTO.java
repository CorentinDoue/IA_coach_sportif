package fr.emse.IA.IA_coach_sportif.web.seance;

import fr.emse.IA.IA_coach_sportif.model.Muscles;

public final class MusclesDTO {
    private final Long id;
    private final int biceps;
    private final int triceps;
    private final int avantBras;
    private final int trapezes;
    private final int dos;
    private final int pectoraux;
    private final int abdominaux;
    private final int epaules;
    private final int quadriceps;
    private final int ischios;
    private final int fessiers;
    private final int cardio;

    public MusclesDTO(Muscles muscles) {
        this.id = muscles.getId();
        this.abdominaux = muscles.getAbdominaux();
        this.avantBras = muscles.getAvantBras();
        this.biceps = muscles.getBiceps();
        this.cardio = muscles.getCardio();
        this.dos = muscles.getDos();
        this.epaules =muscles.getEpaules();
        this.fessiers = muscles.getFessiers();
        this.ischios = muscles.getIschios();
        this.pectoraux = muscles.getPectoraux();
        this.quadriceps = muscles.getQuadriceps();
        this.trapezes = muscles.getTrapezes();
        this.triceps = muscles.getTriceps();
    }

    public Long getId() {
        return id;
    }

    public int getTriceps() {
        return triceps;
    }

    public int getQuadriceps() {
        return quadriceps;
    }

    public int getIschios() {
        return ischios;
    }

    public int getFessiers() {
        return fessiers;
    }

    public int getEpaules() {
        return epaules;
    }

    public int getPectoraux() {
        return pectoraux;
    }

    public int getDos() {
        return dos;
    }

    public int getCardio() {
        return cardio;
    }

    public int getBiceps() {
        return biceps;
    }

    public int getAbdominaux() {
        return abdominaux;
    }

    public int getAvantBras() {
        return avantBras;
    }

    public int getTrapezes() {
        return trapezes;
    }
}
