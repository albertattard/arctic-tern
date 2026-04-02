package game.arctictern.persistence.repository;

import game.arctictern.domain.MessageRole;
import game.arctictern.persistence.entity.SessionMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SessionMessageRepository extends JpaRepository<SessionMessageEntity, UUID> {

    Optional<SessionMessageEntity> findTopBySessionIdAndRoleOrderByCreatedAtDesc(UUID sessionId, MessageRole role);
}
