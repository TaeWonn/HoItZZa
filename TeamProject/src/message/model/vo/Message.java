package message.model.vo;

import java.sql.Date;

public class Message {
	
	private int messageNo;
	private String sender;
	private String recipient;
	private String content;
	private Date noteDate;
	private String noteDel;

	public Message() {}
	
	
	public Message(int messageNo, String sender, String recipient, String content, Date noteDate, String noteDel) {
		super();
		this.messageNo = messageNo;
		this.sender = sender;
		this.recipient = recipient;
		this.content = content;
		this.noteDate = noteDate;
		this.noteDel = noteDel;
	}
	public int getMessageNo() {
		return messageNo;
	}
	public void setMessageNo(int messageNo) {
		this.messageNo = messageNo;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getNoteDate() {
		return noteDate;
	}
	public void setNoteDate(Date noteDate) {
		this.noteDate = noteDate;
	}
	public String getNoteDel() {
		return noteDel;
	}
	public void setNoteDel(String noteDel) {
		this.noteDel = noteDel;
	}
	@Override
	public String toString() {
		return "Message [messageNo=" + messageNo + ", sender=" + sender + ", recipient=" + recipient + ", content="
				+ content + ", noteDate=" + noteDate + ", noteDel=" + noteDel + "]";
	}
	
	

}
