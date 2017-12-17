package fr.emse.IA.IA_coach_sportif.web.caracteristique;

import fr.emse.IA.IA_coach_sportif.dao.CaracteristiqueDao;
import fr.emse.IA.IA_coach_sportif.dao.UserDao;
import fr.emse.IA.IA_coach_sportif.model.User;
import fr.emse.IA.IA_coach_sportif.web.exception.NotFoundException;
import fr.emse.IA.IA_coach_sportif.web.security.CurrentUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller used to handle users and their passwords
 * @author JB Nizet
 */
@RestController
@Transactional
@RequestMapping("/api/stats")
public class CaracteristiqueController {

    private final CurrentUser currentUser;
    private final CaracteristiqueDao caracteristiqueDao;
    private final UserDao userDao;

    public CaracteristiqueController(CurrentUser currentUser,
                                     CaracteristiqueDao caracteristiqueDao,
                                     UserDao userDao
                            ) {
        this.currentUser = currentUser;
        this.caracteristiqueDao = caracteristiqueDao;
        this.userDao = userDao;
    }

    @GetMapping
    //@AdminOnly
    public List<CaracteristiqueDTO> list() {
        return caracteristiqueDao.findAll().stream().map(CaracteristiqueDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/me")
    public List<CaracteristiqueDTO> getCurrentUser() {
        User user = userDao.findById(currentUser.getUserId()).orElseThrow(NotFoundException::new);
        List<CaracteristiqueDTO> histo = user.getHisto_caracteristiques()== null ? null: user.getHisto_caracteristiques().stream().map(CaracteristiqueDTO::new).collect(Collectors.toList());
        return histo;
    }

    @GetMapping("/{userId}")
    //@AdminOnly:
    public List<CaracteristiqueDTO> get(@PathVariable("userId") Long userId) {
        User user = userDao.findById(userId).orElseThrow(NotFoundException::new);
        List<CaracteristiqueDTO> histo = user.getHisto_caracteristiques()== null ? null: user.getHisto_caracteristiques().stream().map(CaracteristiqueDTO::new).collect(Collectors.toList());
        return histo;
    }
}
