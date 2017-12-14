package fr.emse.IA.IA_coach_sportif.web.users;

import fr.emse.IA.IA_coach_sportif.model.Sexe;
import fr.emse.IA.IA_coach_sportif.model.User;

import java.util.Date;

public final class UserDTO {
    private final Long id;
    private final String login;
    private final boolean admin;
    private final String password;
    private final Sexe sexe;
    private final Date date_naissance;

    public UserDTO(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.admin = user.isAdmin();
        this.password = user.getPassword();
        this.sexe = user.getSexe();
        this.date_naissance = user.getDate_naissance();
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public boolean isAdmin() {
        return admin;
    }

    public String getPassword() {
        return password;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }
}
