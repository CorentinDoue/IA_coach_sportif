package fr.emse.IA.IA_coach_sportif.dao;

import fr.emse.IA.IA_coach_sportif.model.Caracteristique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaracteristiqueDao extends JpaRepository<Caracteristique, Long>{
}

