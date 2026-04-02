package game.arctictern.persistence.repository;

import game.arctictern.persistence.entity.SessionDecisionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SessionDecisionRepository extends JpaRepository<SessionDecisionEntity, UUID> {

    List<SessionDecisionEntity> findAllBySessionIdOrderByCreatedAtAsc(UUID sessionId);
}
