package fr.emse.IA.IA_coach_sportif.web.seance;

import fr.emse.IA.IA_coach_sportif.AI.csp.core.Assignment;
import fr.emse.IA.IA_coach_sportif.AI.csp.core.MinConflictsStrategy;
import fr.emse.IA.IA_coach_sportif.AI.csp.nqueens.NQueensCSP;
import fr.emse.IA.IA_coach_sportif.dao.ExerciceDao;
import fr.emse.IA.IA_coach_sportif.dao.UserDao;
import fr.emse.IA.IA_coach_sportif.model.Activite;
import fr.emse.IA.IA_coach_sportif.model.Exercice;
import fr.emse.IA.IA_coach_sportif.model.Seance;
import fr.emse.IA.IA_coach_sportif.model.User;
import fr.emse.IA.IA_coach_sportif.web.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SeanceService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ExerciceDao exerciceDao;

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

    public String SolveNQueens(int N){
        Assignment sol;
        NQueensCSP map = new NQueensCSP(N);
        MinConflictsStrategy mcs = new MinConflictsStrategy(100000);
        sol = mcs.solve(map);

        return sol.toString();
    }
}
