package ro.andrei.webapp.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ro.andrei.webapp.service.TodoEntryService;

@Controller
@RequestMapping("/")
public class TodoEntryController {

	@Autowired
	@Qualifier("todoEntryService")
	private TodoEntryService todoEntryService;
	
	
}
