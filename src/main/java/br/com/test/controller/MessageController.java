package br.com.test.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.test.model.Message;
import br.com.test.model.dto.MessageDTO;
import br.com.test.repository.MessageRepository;
import br.com.test.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiResponses(
		value= {@ApiResponse(code = 200, message="Chamada OK"),
				@ApiResponse(code = 404, message="Requisição não disponível")})

@RestController
@RequestMapping("messages")
@Api(value="Messages Resource")
public class MessageController {
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private MessageService messageService;
	
	@ApiOperation(value = "Método responsável por retornar uma Mensagem com base no ID informado.")
	@GetMapping(value="/{id}", produces = "application/json")
	public Message getById(@PathVariable UUID id) {
		return this.getMessageRepository().findById(id).get();
	}
	
	@ApiOperation(value = "Método responsável enviar uma mensagem à um destinatário.")
	@PostMapping(produces = "application/json")
	public MessageDTO send(@RequestBody MessageDTO messageDTO) {
		return this.getMessageService().send(messageDTO);
	}
	
	@ApiOperation(value = "Método responsável por exibir todas as mensagens relacionadas a uma conversa.")
	@GetMapping(produces = "application/json")
	public List<MessageDTO> getMessagesByConversationId(@RequestParam UUID conversationId) {
		return this.getMessageService().getMessagesByConversationId(conversationId);
	}

	public MessageRepository getMessageRepository() {
		return messageRepository;
	}

	public void setMessageRepository(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
}
