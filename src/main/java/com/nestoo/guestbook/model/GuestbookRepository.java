package com.nestoo.guestbook.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestbookRepository extends CrudRepository<Guestbook, Integer>{
	
	 public Iterable<Guestbook> findGuestByName(@Param("name") String name);

}
