package fr.emse.IA.IA_coach_sportif.web.seance;

import fr.emse.IA.IA_coach_sportif.dao.ExerciceDao;
import fr.emse.IA.IA_coach_sportif.dao.SeanceDao;
import fr.emse.IA.IA_coach_sportif.dao.UserDao;
import fr.emse.IA.IA_coach_sportif.model.Activite;
import fr.emse.IA.IA_coach_sportif.model.Exercice;
import fr.emse.IA.IA_coach_sportif.model.Seance;
import fr.emse.IA.IA_coach_sportif.model.User;
import fr.emse.IA.IA_coach_sportif.web.exception.NotFoundException;
import fr.emse.IA.IA_coach_sportif.web.security.CurrentUser;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Controller used to handle users and their passwords
 * @author JB Nizet
 */
@RestController
@Transactional
@RequestMapping("/api/seances")
public class SeanceController {

    private final CurrentUser currentUser;
    private final SeanceDao seanceDao;
    private final UserDao userDao;
    private final ExerciceDao exerciceDao;


    public SeanceController(CurrentUser currentUser,
                            SeanceDao seanceDao,
                            UserDao userDao,
                            ExerciceDao exerciceDao
                            ) {
        this.currentUser = currentUser;
        this.seanceDao = seanceDao;
        this.userDao = userDao;
        this.exerciceDao = exerciceDao;
    }

    @GetMapping
    //@AdminOnly
    public List<SeanceDTO> list() {
        return seanceDao.findAll().stream().map(SeanceDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/me")
    public List<SeanceDTO> getCurrentUser() {
        User user = userDao.findById(currentUser.getUserId()).orElseThrow(NotFoundException::new);
        List<SeanceDTO> seances = user.getHisto_seance()== null ? null: user.getHisto_seance().stream().map(SeanceDTO::new).collect(Collectors.toList());
        return seances;
    }

    @GetMapping("/{userId}")
    //@AdminOnly:
    public List<SeanceDTO> get(@PathVariable("userId") Long userId) {
        User user = userDao.findById(userId).orElseThrow(NotFoundException::new);
        List<SeanceDTO> seances = user.getHisto_seance()== null ? null: user.getHisto_seance().stream().map(SeanceDTO::new).collect(Collectors.toList());
        return seances;
    }


    @PostMapping("/me/test")
    public SeanceDTO newTestCurrentUser(){
        return createTest(currentUser.getUserId());
    }


    @PostMapping("/{userId}/test")
    @ResponseStatus(HttpStatus.CREATED)
    //@AdminOnly
    public SeanceDTO newTest(@PathVariable("userId") Long userId){
        return createTest(userId);
    }

    public SeanceDTO createTest(Long id_user) {
        User user = userDao.findById(id_user).orElseThrow(NotFoundException::new);
        Seance seance = new Seance();
        seance.setDate(new Date());
        List<Activite> activites =new ArrayList<>();
        Activite activite;
        Exercice exercice;
        int id_ex;
        int repet;
        int poids;
        int nb_ex;
        int nb_repet;
        Random random = new Random();
        nb_ex = random.nextInt(3)+3;
        nb_repet = random.nextInt(6-nb_ex)+2;
        for (int i = 0; i < nb_ex; i++) {
            activite =new Activite();
            id_ex=random.nextInt(58) + 1;
            exercice = exerciceDao.getOne(new Long(id_ex));
            activite.setExercice(exercice);
            if (exercice.isPoids()){
                poids = random.nextInt(20)+10;
                activite.setPoids(poids);
            }else{
                activite.setPoids(0);
            }
            if (exercice.isRepetition()){
                repet = random.nextInt(20)+10;
                activite.setRepetition(repet);
                activite.setTemporisation(0);
            }else{
                repet = random.nextInt(6)*10+30;
                activite.setRepetition(0);
                activite.setTemporisation(repet);
            }
            activites.add(activite);

            if (i<nb_ex-1){
                activite =new Activite();
                exercice = exerciceDao.getOne(new Long(0));
                activite.setExercice(exercice);
                activite.setPoids(0);

                activite.setRepetition(0);

                repet = random.nextInt(6)*10+30;

                activite.setTemporisation(repet);
            }else {
                activite =new Activite();
                exercice = exerciceDao.getOne(new Long(0));
                activite.setExercice(exercice);
                activite.setPoids(0);

                activite.setRepetition(0);

                repet = random.nextInt(12)*10+90;

                activite.setTemporisation(repet);
            }
            activites.add(activite);
        }
        for (int i = 0; i < nb_repet-1; i++) {
            for (int j = 0; j < nb_ex; j++) {
                activites.add(activites.get(2*j).copy());
                if (i<nb_repet-2 || j< nb_ex-1){
                    activites.add(activites.get(2*j+1).copy());
                }
            }
        }
        seance.setActivites(activites);
        List<Seance> seances = user.getHisto_seance();
        seances.add(seance);
        user.setHisto_seance(seances);
        return new SeanceDTO(seance);
    }
}
