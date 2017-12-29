package fr.emse.IA.IA_coach_sportif.web.seance;

import fr.emse.IA.IA_coach_sportif.dao.ExerciceDao;
import fr.emse.IA.IA_coach_sportif.dao.SeanceDao;
import fr.emse.IA.IA_coach_sportif.dao.UserDao;
import fr.emse.IA.IA_coach_sportif.model.User;
import fr.emse.IA.IA_coach_sportif.web.exception.NotFoundException;
import fr.emse.IA.IA_coach_sportif.web.security.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller used to handle users and their passwords
 * @author JB Nizet
 */
@RestController
@Transactional
@RequestMapping("/api/seances")
public class SeanceController {

    @Autowired
    private CurrentUser currentUser;

    @Autowired
    private SeanceDao seanceDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ExerciceDao exerciceDao;

    @Autowired
    private SeanceService seanceService;


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
        return seanceService.createTest(currentUser.getUserId());
    }


    @PostMapping("/{userId}/test")
    @ResponseStatus(HttpStatus.CREATED)
    //@AdminOnly
    public SeanceDTO newTest(@PathVariable("userId") Long userId){
        return seanceService.createTest(userId);
    }

    @GetMapping("/NQueens/{N}")
    public String solveNQueens(@PathVariable("N") int N) { return seanceService.SolveNQueens(N);}


}
