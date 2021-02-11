package modelos;

import java.time.LocalTime;

public class ChatMessage {
	private String userName;
	private String message;
	private LocalTime time;
	
	public ChatMessage() {
	}
	
	public ChatMessage(String userName, String message, LocalTime time) {
		super();
		this.userName = userName;
		this.message = message;
		this.time = time;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
}