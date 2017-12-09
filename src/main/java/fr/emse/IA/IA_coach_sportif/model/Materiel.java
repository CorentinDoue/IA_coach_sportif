package fr.emse.IA.IA_coach_sportif.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Materiel {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Materiel(){}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
