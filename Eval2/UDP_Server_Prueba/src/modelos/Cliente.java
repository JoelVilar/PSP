package modelos;

import java.io.Serializable;
import java.time.LocalDate;

public class Cliente implements Serializable{
	private int id;
	private String name;
	
	public Cliente() {
		super();
	}
	
	public Cliente(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
