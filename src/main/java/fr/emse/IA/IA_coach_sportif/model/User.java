
package fr.emse.IA.IA_coach_sportif.model;

import javax.persistence.*;
import java.util.List;

@Entity
@SuppressWarnings("serial")
public class User {

    private static final String USER_GENERATOR = "UserGenerator";

    @Id
    @SequenceGenerator(name = USER_GENERATOR, sequenceName = "GUSER_SEQ", initialValue = 2, allocationSize = 1)
    @GeneratedValue(generator = USER_GENERATOR)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;



    @Column(nullable = false)
    private boolean admin;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Caracteristique> histo_caracteristiques;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seance> histo_seance;

    @SuppressWarnings("unused")
    public User() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Caracteristique> getHisto_caracteristiques() {
        return histo_caracteristiques;
    }

    public List<Seance> getHisto_seance() {
        return histo_seance;
    }

    public void setHisto_caracteristiques(List<Caracteristique> histo_caracteristiques) {
        this.histo_caracteristiques = histo_caracteristiques;
    }

    public void setHisto_seance(List<Seance> histo_seance) {
        this.histo_seance = histo_seance;
    }
}


