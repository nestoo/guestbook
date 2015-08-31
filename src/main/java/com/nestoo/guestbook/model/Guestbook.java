package com.nestoo.guestbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "guestbooks")
public class Guestbook {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	 
	private String text;

	public Guestbook() {
	}

	
	public Guestbook(long id) {
		 this.id = id;
	}

	public Guestbook(String name, String text) {
		this.name = name;
		this.text = text;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return String.format("Guestbook[id=%d, name='%s', text='%s']",
				id, name, text);
	}
}
