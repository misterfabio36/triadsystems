package br.com.test.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.test.model.Bot;
import br.com.test.repository.BotRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiResponses(
		value= {@ApiResponse(code = 200, message="Chamada OK"),
				@ApiResponse(code = 404, message="Requisição não disponível")})

@RestController
@RequestMapping("bots")
@Api(value="Bot Resource")
public class BotController {
	
	@Autowired
	private BotRepository botRepository;
	
	@ApiOperation(value = "Método responsável por retornar um Bot com base no ID informado.")
	@GetMapping(value="/{id}", produces = "application/json")
	public Bot getById(@PathVariable UUID id) {
		return this.getBotRepository().findById(id).get();
	}
	
	@ApiOperation(value = "Método responsável por atualizar os dados de um Bot.")
	@PutMapping(produces = "application/json")
	public Bot update(@RequestBody Bot botParameter) {
		if(botParameter.getId() != null) {
			Optional<Bot> bot = this.getBotRepository().findById(botParameter.getId());
			if(bot.isPresent()) {
				Bot botOnDB = bot.get();
				botOnDB.setName(botParameter.getName());
				this.getBotRepository().save(botOnDB);
				return botOnDB;
			}
		}
		return null;
	}
	
	@ApiOperation(value = "Método responsável por incluir um novo Bot (Exemplo de JSON: {'name': 'Fasdsdsbio'})")
	@PostMapping(produces = "application/json")
	public Bot save(@RequestBody Bot botParameter) {
		botParameter.setId(null);
		return this.getBotRepository().save(botParameter);
	}
	
	@ApiOperation(value = "Método responsável por excluir um Bot (Exemplo: http://localhost:8080/BotApi/bots/4a16d21b-4117-423b-8864-1a13089f113d)")
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable UUID id) {
		this.getBotRepository().deleteById(id);
	}

	public BotRepository getBotRepository() {
		return botRepository;
	}

	public void setBotRepository(BotRepository botRepository) {
		this.botRepository = botRepository;
	}
}
