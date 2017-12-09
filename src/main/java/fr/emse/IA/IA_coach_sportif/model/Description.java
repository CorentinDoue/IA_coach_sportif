package fr.emse.IA.IA_coach_sportif.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Description {

    @Id
    @GeneratedValue
    private Long id;

    private String texte;

    private String image;

    private int tempo;

    public Description(){}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getTexte() {
        return texte;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

}
