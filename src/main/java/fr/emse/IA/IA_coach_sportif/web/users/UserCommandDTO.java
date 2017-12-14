package fr.emse.IA.IA_coach_sportif.web.users;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.emse.IA.IA_coach_sportif.model.Sexe;

import java.util.Date;

/**
 * Command passed to create or update a user
 * @author JB Nizet
 */
public final class UserCommandDTO {

    private final String login;
    private final boolean admin;
    private final String password;
    private final Sexe sexe;
    private final Date date_naissance;

    @JsonCreator
    public UserCommandDTO(@JsonProperty("login") String login,
                          @JsonProperty("admin") boolean admin,
                          @JsonProperty("sexe") Sexe sexe,
                          @JsonProperty("password") String password,
                          @JsonProperty("date_naissance") Date date_naissance
                         ) {
        this.login = login;
        this.password = password;
        this.admin = admin;
        this.sexe = sexe;
        this.date_naissance = date_naissance;

    }


    public String getLogin() {
        return login;
    }

    public boolean isAdmin() {
        return admin;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public String getPassword() {
        return password;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }
}
