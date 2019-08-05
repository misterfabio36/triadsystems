package br.com.test.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import br.com.test.model.Message;

@Component
public interface MessageRepository extends JpaRepository<Message, UUID>{
}
