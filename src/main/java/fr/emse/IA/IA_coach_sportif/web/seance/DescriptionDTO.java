package fr.emse.IA.IA_coach_sportif.web.seance;

import fr.emse.IA.IA_coach_sportif.model.Description;

public final class DescriptionDTO {
    private final Long id;

    private final String texte;

    private final String image;

    private final int tempo;

    public DescriptionDTO(Description description) {
        this.id = description.getId();
        this.image = description.getImage();
        this.tempo = description.getTempo();
        this.texte = description.getTexte();
    }

    public Long getId() {
        return id;
    }

    public int getTempo() {
        return tempo;
    }

    public String getImage() {
        return image;
    }

    public String getTexte() {
        return texte;
    }
}
