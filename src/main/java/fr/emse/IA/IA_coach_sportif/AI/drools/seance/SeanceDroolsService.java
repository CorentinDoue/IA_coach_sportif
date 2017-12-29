package fr.emse.IA.IA_coach_sportif.AI.drools.seance;

import fr.emse.IA.IA_coach_sportif.dao.SeanceDao;
import fr.emse.IA.IA_coach_sportif.dao.UserDao;
import fr.emse.IA.IA_coach_sportif.web.security.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SeanceDroolsService {

    @Autowired
    private SeanceDao seanceDao;

    @Autowired
    private CurrentUser currentUser;

    @Autowired
    private UserDao userDao;


}
