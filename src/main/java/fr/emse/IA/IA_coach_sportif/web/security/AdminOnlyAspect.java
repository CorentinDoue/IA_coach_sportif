package fr.emse.IA.IA_coach_sportif.web.security;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import fr.emse.IA.IA_coach_sportif.dao.UserDao;
import fr.emse.IA.IA_coach_sportif.model.User;
import fr.emse.IA.IA_coach_sportif.web.exception.ForbiddenException;
import org.springframework.stereotype.Component;

/**
 * Aspect allowing to check that the current user is an admin before invoking a controller method.
 * This aspect is installed by annotating a method with {@link AdminOnly}
 *
 * @author JB Nizet
 */
@Aspect
@Component
public class AdminOnlyAspect {

    private final CurrentUser currentUser;
    private final UserDao userDao;

    public AdminOnlyAspect(CurrentUser currentUser, UserDao userDao) {
        this.currentUser = currentUser;
        this.userDao = userDao;
    }

    @Before("@annotation(adminOnly)")
    public void checkUserIsAdmin(AdminOnly adminOnly) {
        userDao.findById(currentUser.getUserId()).filter(User::isAdmin).orElseThrow(ForbiddenException::new);
    }
}
