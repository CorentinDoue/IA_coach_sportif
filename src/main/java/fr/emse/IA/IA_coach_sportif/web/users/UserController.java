package fr.emse.IA.IA_coach_sportif.web.users;

import fr.emse.IA.IA_coach_sportif.dao.UserDao;
import fr.emse.IA.IA_coach_sportif.model.Caracteristique;
import fr.emse.IA.IA_coach_sportif.model.Materiels;
import fr.emse.IA.IA_coach_sportif.model.Objectif;
import fr.emse.IA.IA_coach_sportif.model.User;
import fr.emse.IA.IA_coach_sportif.web.exception.BadRequestException;
import fr.emse.IA.IA_coach_sportif.web.exception.ErrorCode;
import fr.emse.IA.IA_coach_sportif.web.exception.NotFoundException;
import fr.emse.IA.IA_coach_sportif.web.seance.MaterielsDTO;
import fr.emse.IA.IA_coach_sportif.web.security.AuthenticatedUserDTO;
import fr.emse.IA.IA_coach_sportif.web.security.CurrentUser;
import fr.emse.IA.IA_coach_sportif.web.security.JwtHelper;
import fr.emse.IA.IA_coach_sportif.web.security.PasswordDigester;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller used to handle users and their passwords
 * @author JB Nizet
 */
@RestController
@Transactional
@RequestMapping("/api/users")
public class UserController {

    private final CurrentUser currentUser;
    private final UserDao userDao;
    private final PasswordGenerator passwordGenerator;
    private final PasswordDigester passwordDigester;
    private final JwtHelper jwtHelper;

    public UserController(CurrentUser currentUser,
                          UserDao userDao,
                          PasswordGenerator passwordGenerator,
                          PasswordDigester passwordDigester,
                          JwtHelper jwtHelper) {
        this.currentUser = currentUser;
        this.userDao = userDao;
        this.passwordGenerator = passwordGenerator;
        this.passwordDigester = passwordDigester;
        this.jwtHelper = jwtHelper;
    }

    @GetMapping("/me")
    public CurrentUserDTO getCurrentUser() {
        User user = userDao.findById(currentUser.getUserId()).orElseThrow(NotFoundException::new);
        return new CurrentUserDTO(user);
    }

    @PutMapping("/me/passwords")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void changePassword(@Validated @RequestBody ChangePasswordCommandDTO command) {
        User user = userDao.findById(currentUser.getUserId()).orElseThrow(NotFoundException::new);
        user.setPassword(passwordDigester.hash(command.getNewPassword()));
    }

    @GetMapping
    //@AdminOnly
    public List<UserDTO> list() {
        return userDao.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/{userId}")
    //@AdminOnly
    public UserDTO get(@PathVariable("userId") Long userId) {
        return userDao.findById(userId).map(UserDTO::new).orElseThrow(NotFoundException::new);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //@AdminOnly
    public AuthenticatedUserDTO create(@Validated @RequestBody UserCommandCaracteristiqueDTO command) throws BadRequestException {
        if (userDao.existsByLogin(command.getLogin())) {
            throw new BadRequestException(ErrorCode.USER_LOGIN_ALREADY_EXISTS);
        }
        User user = new User();
        copyCommandToUser(command, user);

        user.setPassword(passwordDigester.hash(command.getPassword()));

        userDao.save(user);

        return new AuthenticatedUserDTO(user, jwtHelper.buildToken(user.getId()));
    }

    @PutMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    //@AdminOnly
    public void update(@PathVariable("userId") Long userId, @Validated @RequestBody UserDTO command) {
        User user = userDao.findById(userId).orElseThrow(() -> new NotFoundException("No user with ID " + userId));

        userDao.findByLogin(command.getLogin()).filter(other -> !other.getId().equals(userId)).ifPresent(other -> {
            throw new BadRequestException(ErrorCode.USER_LOGIN_ALREADY_EXISTS);
        });

        copyCommandToUser(command, user);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    //@AdminOnly
    public void delete(@PathVariable("userId") Long userId) {
        userDao.findById(userId).ifPresent(userDao::delete);
    }

    @PostMapping("/{userId}/password-resets")
    @ResponseStatus(HttpStatus.CREATED)
    //@AdminOnly
    public UserWithPasswordDTO resetPassword(@PathVariable("userId") Long userId) {
        User user = userDao.findById(userId).orElseThrow(() -> new NotFoundException("No user with ID " + userId));
        String generatedPassword = passwordGenerator.generatePassword();
        user.setPassword(passwordDigester.hash(generatedPassword));
        return new UserWithPasswordDTO(user, generatedPassword);
    }

    @PutMapping("/me/objectif")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void changeObjectif(@Validated @RequestBody Objectif objectif) {
        User user = userDao.findById(currentUser.getUserId()).orElseThrow(NotFoundException::new);
        user.setObjectif(objectif);
    }

    @GetMapping("/me/objectif")
    public Objectif getObjectif() {
        User user = userDao.findById(currentUser.getUserId()).orElseThrow(NotFoundException::new);
        return user.getObjectif();
    }

    @PutMapping("/{userId}/objectif")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    //@AdminOnly
    public void changeObjectif(@PathVariable("userId") Long userId, @Validated @RequestBody Objectif objectif) {
        User user = userDao.findById(userId).orElseThrow(NotFoundException::new);
        user.setObjectif(objectif);
    }

    @GetMapping("/{userId}/objectif")
    //@AdminOnly
    public Objectif getObjectif(@PathVariable("userId") Long userId) {
        User user = userDao.findById(userId).orElseThrow(NotFoundException::new);
        return user.getObjectif();
    }

    @PutMapping("/me/niveau")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void changeNiveau(@Validated @RequestBody Double niveau) {
        User user = userDao.findById(currentUser.getUserId()).orElseThrow(NotFoundException::new);
        user.setNiveau(niveau);
    }

    @GetMapping("/me/niveau")
    public Double getNiveau() {
        User user = userDao.findById(currentUser.getUserId()).orElseThrow(NotFoundException::new);
        return user.getNiveau();
    }

    @PutMapping("/{userId}/niveau")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    //@AdminOnly
    public void changeNiveau(@PathVariable("userId") Long userId, @Validated @RequestBody Double niveau) {
        User user = userDao.findById(userId).orElseThrow(NotFoundException::new);
        user.setNiveau(niveau);
    }

    @GetMapping("/{userId}/niveau")
    //@AdminOnly
    public Double getNiveau(@PathVariable("userId") Long userId) {
        User user = userDao.findById(userId).orElseThrow(NotFoundException::new);
        return user.getNiveau();
    }

    @PutMapping("/me/materiels")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void changeMateriels(@Validated @RequestBody UserMaterielsDTO userMaterielsDTO) {
        User user = userDao.findById(currentUser.getUserId()).orElseThrow(NotFoundException::new);
        Materiels materiels = new Materiels(userMaterielsDTO);
        user.setMateriels(materiels);
    }

    @GetMapping("/me/materiels")
    public MaterielsDTO getMateriels() {
        User user = userDao.findById(currentUser.getUserId()).orElseThrow(NotFoundException::new);
        Materiels materiels = user.getMateriels();
        return new MaterielsDTO(materiels);
    }

    @PutMapping("/{userId}/materiels")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    //@AdminOnly
    public void changeMateriels(@PathVariable("userId") Long userId, @Validated @RequestBody UserMaterielsDTO userMaterielsDTO) {
        User user = userDao.findById(userId).orElseThrow(NotFoundException::new);
        Materiels materiels = new Materiels(userMaterielsDTO);
        user.setMateriels(materiels);
    }

    @GetMapping("/{userId}/materiels")
    //@AdminOnly
    public MaterielsDTO getMateriels(@PathVariable("userId") Long userId) {
        User user = userDao.findById(userId).orElseThrow(NotFoundException::new);
        Materiels materiels = user.getMateriels();
        return new MaterielsDTO(materiels);
    }

    private void copyCommandToUser(UserDTO command, User user) {
        user.setLogin(command.getLogin());
        user.setAdmin(command.isAdmin());
        user.setSexe(command.getSexe());
        user.setDate_naissance(command.getDate_naissance());
    }

    private void copyCommandToUser(UserCommandCaracteristiqueDTO command, User user) {
        user.setLogin(command.getLogin());
        user.setAdmin(command.isAdmin());
        user.setSexe(command.getSexe());
        user.setDate_naissance(command.getDate_naissance());
        Caracteristique caracteristique = new Caracteristique();
        caracteristique.setPoids(command.getCaracteristique().getPoids());
        caracteristique.setTaille(command.getCaracteristique().getPoids());
        caracteristique.setDate(new Date());
        List<Caracteristique> caracteristiques =new ArrayList<>();
        caracteristiques.add(caracteristique);
        user.setHisto_caracteristiques(caracteristiques);
    }
}
