package br.com.test.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;

import br.com.test.model.Bot;

@Component
public interface BotRepository extends JpaRepository<Bot, UUID>{
}
