package com.nestoo.guestbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nestoo.guestbook.model.Guestbook;
import com.nestoo.guestbook.model.GuestbookDao;

@Controller
public class StartController {

	@Autowired
	private GuestbookDao guestbookDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {

		StringBuilder sb = new StringBuilder();
		for (Guestbook record : guestbookDao.findAll()) {
			sb.append(record.getName());
			sb.append(" - ");
			sb.append(record.getText());
			sb.append(";	");
		}
		model.addAttribute("book", sb.toString());

		return "index";
	}
}
