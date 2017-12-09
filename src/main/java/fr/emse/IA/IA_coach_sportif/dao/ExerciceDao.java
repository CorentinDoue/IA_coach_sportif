package fr.emse.IA.IA_coach_sportif.dao;

import fr.emse.IA.IA_coach_sportif.model.Exercice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciceDao extends JpaRepository<Exercice, Long>{
}

