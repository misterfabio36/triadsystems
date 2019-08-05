package br.com.test.service;

import java.util.List;
import java.util.UUID;

import br.com.test.model.dto.MessageDTO;

public interface MessageService {
	public MessageDTO send(MessageDTO dto);
	
	public MessageDTO getMessageAsDTO(UUID id);
	
	public List<MessageDTO> getMessagesByConversationId(UUID conversationId);
}