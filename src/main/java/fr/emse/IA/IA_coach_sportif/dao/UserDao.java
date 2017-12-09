package fr.emse.IA.IA_coach_sportif.dao;

import fr.emse.IA.IA_coach_sportif.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Long>{
    Optional<User> findByLogin(String login);

    boolean existsByLogin(String login);
}

