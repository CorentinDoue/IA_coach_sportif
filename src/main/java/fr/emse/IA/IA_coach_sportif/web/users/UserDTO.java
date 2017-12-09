package fr.emse.IA.IA_coach_sportif.web.users;

import fr.emse.IA.IA_coach_sportif.model.User;

public final class UserDTO {
    private final Long id;
    private final String login;
    private final boolean admin;
    private final String nom;
    private final String prenom;
    private final String password;

    public UserDTO(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.admin = user.isAdmin();
        this.nom = user.getNom();
        this.prenom = user.getPrenom();
        this.password = user.getPassword();
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
