package ro.andrei.webapp.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ro.andrei.webapp.domain.Notebook;
import ro.andrei.webapp.service.NotebookService;

@Controller
@RequestMapping("/notebook")
public class NotebookController {

	@Autowired
	@Qualifier("notebookService")
	private NotebookService notebookService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Notebook>> getAllForUser(@RequestParam("userId") Long userId) {
		List<Notebook> notebooks = notebookService.findForUser(userId);
		if(notebooks != null) {
			return new ResponseEntity<List<Notebook>>(notebooks, HttpStatus.OK);
		}
		return new ResponseEntity<List<Notebook>>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/{notebookId}", method = RequestMethod.GET)
	public ResponseEntity<Notebook> getNotebook(@PathVariable("notebookId") Long notebookId) {
		Notebook notebook = notebookService.find(notebookId);
		if (notebookId != null) {
			return new ResponseEntity<Notebook>(notebook, HttpStatus.OK);
		}
		return new ResponseEntity<Notebook>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/{notebookId}", method = RequestMethod.DELETE)
	public ResponseEntity<Notebook> deleteNotebook(@PathVariable("notebookId") Long notebookId) {
		Notebook notebook = notebookService.delete(notebookId);
		if(notebook != null) {
			return new ResponseEntity<Notebook>(notebook, HttpStatus.OK);
		}
		return new ResponseEntity<Notebook>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/new", method = RequestMethod.POST)
	public ResponseEntity<Notebook> createNotebook(@RequestBody Notebook notebook) {
			notebook = notebookService.create(notebook);
			if(notebook.getId()!=null) {
				return new ResponseEntity<Notebook>(notebook, HttpStatus.OK);
			}
			return new ResponseEntity<Notebook>(HttpStatus.NOT_FOUND);
	}
}
