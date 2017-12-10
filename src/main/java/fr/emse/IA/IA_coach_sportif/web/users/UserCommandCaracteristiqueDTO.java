package fr.emse.IA.IA_coach_sportif.web.users;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.emse.IA.IA_coach_sportif.model.Sexe;

/**
 * Command passed to create or update a user
 * @author JB Nizet
 */
public final class UserCommandCaracteristiqueDTO {

    private final String login;
    private final boolean admin;
    private final String password;
    private final Sexe sexe;
    private final CaracteristiqueCommandDTO caracteristique;

    @JsonCreator
    public UserCommandCaracteristiqueDTO(@JsonProperty("login") String login,
                                         @JsonProperty("admin") boolean admin,
                                         @JsonProperty("sexe") Sexe sexe,
                                         @JsonProperty("password") String password,
                                         @JsonProperty("caracteristique") CaracteristiqueCommandDTO caracteristique
                                        ) {
        this.login = login;
        this.password = password;
        this.admin = admin;
        this.sexe = sexe;
        this.caracteristique = caracteristique;
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

    public CaracteristiqueCommandDTO getCaracteristique() {
        return caracteristique;
    }
}
