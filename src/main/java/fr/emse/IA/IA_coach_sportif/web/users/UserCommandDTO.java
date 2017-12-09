package fr.emse.IA.IA_coach_sportif.web.users;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Command passed to create or update a user
 * @author JB Nizet
 */
public final class UserCommandDTO {

    private final String login;
    private final boolean admin;
    private final String nom;
    private final String prenom;
    private final String password;

    @JsonCreator
    public UserCommandDTO(@JsonProperty("login") String login,
                          @JsonProperty("admin") boolean admin,
                          @JsonProperty("nom") String nom,
                          @JsonProperty("prenom") String prenom,
                          @JsonProperty("password") String password
                          ) {
        this.login = login;
        this.password = password;
        this.admin = admin;
        this.nom = nom;
        this.prenom = prenom;
    }


    public String getLogin() {
        return login;
    }

    public boolean isAdmin() {
        return admin;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getPassword() {
        return password;
    }
}
