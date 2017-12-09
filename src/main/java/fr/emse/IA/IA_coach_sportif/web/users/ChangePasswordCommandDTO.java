package fr.emse.IA.IA_coach_sportif.web.users;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

/**
 * Command sent to change the password of the current user
 * @author JB Nizet
 */
public final class ChangePasswordCommandDTO {
    @NotEmpty
    private String newPassword;

    @JsonCreator
    public ChangePasswordCommandDTO(@JsonProperty String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
