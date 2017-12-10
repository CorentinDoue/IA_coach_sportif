package fr.emse.IA.IA_coach_sportif.web.users;

import fr.emse.IA.IA_coach_sportif.model.Sexe;
import fr.emse.IA.IA_coach_sportif.model.User;

public final class UserDTO {
    private final Long id;
    private final String login;
    private final boolean admin;
    private final String password;
    private final Sexe sexe;

    public UserDTO(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.admin = user.isAdmin();
        this.password = user.getPassword();
        this.sexe = user.getSexe();
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
}
