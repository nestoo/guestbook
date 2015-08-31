package com.nestoo.guestbook.model;

import org.springframework.data.repository.CrudRepository;

public interface GuestbookDao extends CrudRepository<Guestbook, Long>{

	 public Guestbook findByName(String name);
}
