package com.nestoo.guestbook;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.nestoo.guestbook.model.Guestbook;
import com.nestoo.guestbook.model.GuestbookDao;

@Component
public class GuestbookLoader implements ApplicationListener<ContextRefreshedEvent>{
	 @Autowired
	 private GuestbookDao guestbookDao;
	 
	 private Logger log = Logger.getLogger(GuestbookLoader.class);

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		Guestbook guest = new Guestbook();
		guest.setName("Nesta");
		guest.setText("Labai paprasta sveciu knyga");
		guestbookDao.save(guest);
		
		log.info("Saved guest - id: " + guest.getId());
		
		guest = new Guestbook();
		guest.setName("Jonas");
		guest.setText("Negrazi sveciu knyga");
		guestbookDao.save(guest);

        log.info("Saved guest - id: " + guest.getId());
        
        guest = new Guestbook();
		guest.setName("Pentras");
		guest.setText("Jonas nusisneka");
		guestbookDao.save(guest);

        log.info("Saved guest - id: " + guest.getId());

		
	}
}
