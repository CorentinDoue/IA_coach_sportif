package fr.emse.IA.IA_coach_sportif.dao;

import fr.emse.IA.IA_coach_sportif.model.Activite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActiviteDao extends JpaRepository<Activite, Long>{
}

