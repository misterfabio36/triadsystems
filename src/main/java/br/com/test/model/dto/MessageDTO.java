package br.com.test.model.dto;

import java.util.UUID;

public class MessageDTO {
	private UUID id;
	private UUID conversationId;
	private String timestamp;
	private UUID from;
	private UUID to;
	private String text;

	public UUID getConversationId() {
		return conversationId;
	}

	public void setConversationId(UUID conversationId) {
		this.conversationId = conversationId;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public UUID getFrom() {
		return from;
	}

	public void setFrom(UUID from) {
		this.from = from;
	}

	public UUID getTo() {
		return to;
	}

	public void setTo(UUID to) {
		this.to = to;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
}