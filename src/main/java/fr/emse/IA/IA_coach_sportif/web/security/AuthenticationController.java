package fr.emse.IA.IA_coach_sportif.web.security;

import fr.emse.IA.IA_coach_sportif.dao.UserDao;
import fr.emse.IA.IA_coach_sportif.model.User;
import fr.emse.IA.IA_coach_sportif.web.exception.UnauthorizedException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

/**
 * REST controller used to authenticate users
 * @author JB Nizet
 */
@RestController
@RequestMapping("/api/authentication")
@Transactional
public class AuthenticationController {

    private final UserDao userDao;
    private final PasswordDigester passwordDigester;
    private final JwtHelper jwtHelper;

    public AuthenticationController(UserDao userDao,
                                    PasswordDigester passwordDigester,
                                    JwtHelper jwtHelper) {
        this.userDao = userDao;
        this.passwordDigester = passwordDigester;
        this.jwtHelper = jwtHelper;
    }

    @PostMapping
    public AuthenticatedUserDTO authenticate(@RequestBody CredentialsDTO credentials) {
        User user = userDao.findByLogin(credentials.getLogin()).orElseThrow(UnauthorizedException::new);
        if (!passwordDigester.match(credentials.getPassword(), user.getPassword())) {
            throw new UnauthorizedException();
        }

        return new AuthenticatedUserDTO(user, jwtHelper.buildToken(user.getId()));
    }
}
