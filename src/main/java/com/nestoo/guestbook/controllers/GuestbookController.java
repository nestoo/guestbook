package com.nestoo.guestbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nestoo.guestbook.model.Guestbook;
import com.nestoo.guestbook.model.GuestbookDao;
 

@RestController
@RequestMapping(value = "/guestbook", produces = MediaType.APPLICATION_JSON_VALUE)
public class GuestbookController {
	 
	@Autowired
	private GuestbookDao guestbookDao;

	@RequestMapping
	public Iterable<Guestbook> books() {
		return guestbookDao.findAll();
	}

	@RequestMapping("/delete")
	@ResponseBody
	public String delete(long id) { // delete?id=[id]
		try {
			Guestbook user = new Guestbook(id);
			guestbookDao.delete(user);
		} catch (Exception ex) {
			return "Error deleting the user:" + ex.toString();
		}
		return "User succesfully deleted!";
	}

	@RequestMapping("/get-by-name")
	@ResponseBody
	public String getByEmail(String name) { // get-by-name?name=[name]
		String userId;
		try {
			Guestbook user = guestbookDao.findByName(name);
			userId = String.valueOf(user.getId());
		} catch (Exception ex) {
			return "User not found";
		}
		return "The user id is: " + userId;
	}

	@RequestMapping("/create")
	@ResponseBody
	public String create(String name, String text) { // guestbook/create?name=[name]&text=[text]
		Guestbook guest = null;
		try {
			guest = new Guestbook(name, text);
			guestbookDao.save(guest);
		} catch (Exception ex) {
			return "Error creating the user: " + ex.toString();
		}
		return "User succesfully created! (id = " + guest.getId() + ")";
	}

}
