package game.arctictern.persistence.repository;

import game.arctictern.persistence.entity.PlanningSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlanningSessionRepository extends JpaRepository<PlanningSessionEntity, UUID> {
}
