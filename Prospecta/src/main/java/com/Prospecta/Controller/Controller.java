package com.Prospecta.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Prospecta.Model.Entry;
import com.Prospecta.Model.EntryList;
import com.Prospecta.Service.EntryServiceIntr;

@RestController 
public class Controller {
    @Autowired
    private EntryServiceIntr entryService;
	
	@GetMapping("/EntriesByCategory")
	public ResponseEntity<List<Entry>> EntriesListByCategory(@RequestParam String category){
		List<Entry> list = entryService.ListOfEntryByCategory(category);
		
		return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
	}
}
