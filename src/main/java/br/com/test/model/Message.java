package br.com.test.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "message")
public class Message {

	private UUID id;
	private Conversation conversation;
	private String message;
	private Bot from;
	private Bot to;
	private Date creationDate;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Type(type = "uuid-char")
	@ColumnDefault("random_uuid()")
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_from", nullable = false)
	public Bot getFrom() {
		return from;
	}

	public void setFrom(Bot from) {
		this.from = from;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_to", nullable = false)
	public Bot getTo() {
		return to;
	}

	public void setTo(Bot to) {
		this.to = to;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_conversation", nullable = false)
	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date", nullable = false)
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	@Transient
	public Timestamp getCreationDateASTimestamp() {
		return new Timestamp(creationDate.getTime());
	}
}