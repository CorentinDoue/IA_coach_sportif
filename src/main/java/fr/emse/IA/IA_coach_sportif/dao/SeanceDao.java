package fr.emse.IA.IA_coach_sportif.dao;

import fr.emse.IA.IA_coach_sportif.model.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeanceDao extends JpaRepository<Seance, Long>{
}

