package br.com.test.service.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.test.model.Bot;
import br.com.test.model.Conversation;
import br.com.test.model.Message;
import br.com.test.model.dto.MessageDTO;
import br.com.test.repository.BotRepository;
import br.com.test.repository.ConversationRepository;
import br.com.test.repository.MessageRepository;
import br.com.test.service.MessageService;

@Service("MessageService")
public class MessageServiceImpl implements MessageService{
	
	@Autowired
	private ConversationRepository conversationRepository;
	
	@Autowired
	private BotRepository botRepository;
	
	@Autowired
	private MessageRepository messageRepository;

	public MessageDTO send(MessageDTO dto) {
		Date now = new Date();
		Conversation conversation = null;
		if(dto.getConversationId() == null) {
			conversation = new Conversation();
			conversation.setCreationDate(now);
		}else {
			conversation = this.getConversationRepository().findById(dto.getConversationId()).get();
		}
		
		Message message = new Message();
		message.setCreationDate(now);
		message.setMessage(dto.getText());
				
		this.getConversationRepository().save(conversation);
		message.setConversation(conversation);
		
		Bot from = this.getBotRepository().findById(dto.getFrom()).get();
		Bot to = this.getBotRepository().findById(dto.getTo()).get();
		
		message.setFrom(from);
		message.setTo(to);
		
		this.getMessageRepository().save(message);
		dto.setTimestamp(String.valueOf(message.getCreationDateASTimestamp()));
		dto.setConversationId(conversation.getId());

		
		return dto;
	}
	
	public MessageDTO getMessageAsDTO(UUID id) {
		Message message = this.getMessageRepository().findById(id).get();
		
		MessageDTO messageDTO = new MessageDTO();
		messageDTO.setId(message.getId());
		messageDTO.setConversationId(message.getConversation().getId());
		messageDTO.setFrom(message.getFrom().getId());
		messageDTO.setText(message.getMessage());
		messageDTO.setTo(message.getTo().getId());
		messageDTO.setTimestamp(String.valueOf(message.getCreationDateASTimestamp()));
		messageDTO.setConversationId(message.getConversation().getId());
		
		return messageDTO;
	}
	
	public List<MessageDTO> getMessagesByConversationId(UUID conversationId) {
		List<MessageDTO> messageList = new LinkedList<MessageDTO>(); 
		if(conversationId != null) {
			Conversation conversation = this.getConversationRepository().findById(conversationId).get();
			conversation.getMessages().forEach(message -> messageList.add(this.getMessageAsDTO(message.getId())));	
		}
		
		return messageList;
	}

	public ConversationRepository getConversationRepository() {
		return conversationRepository;
	}

	public void setConversationRepository(ConversationRepository conversationRepository) {
		this.conversationRepository = conversationRepository;
	}

	public BotRepository getBotRepository() {
		return botRepository;
	}

	public void setBotRepository(BotRepository botRepository) {
		this.botRepository = botRepository;
	}

	public MessageRepository getMessageRepository() {
		return messageRepository;
	}

	public void setMessageRepository(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}
}