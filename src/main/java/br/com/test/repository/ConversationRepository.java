package br.com.test.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import br.com.test.model.Conversation;

@Component
public interface ConversationRepository extends JpaRepository<Conversation, UUID>{
}
