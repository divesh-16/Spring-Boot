package com.tca.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tca.entity.Book;
import com.tca.service.BookService;

@RestController
public class BookRestContoller 
{
	@Autowired
	BookService service;
	
	
	@GetMapping(
			value="/{id}", 
			produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> fetchBookById(@PathVariable Integer id)
	{
		return new ResponseEntity<>(service.fetchById(id), HttpStatus.OK);
	}
	
	@GetMapping(value="/books", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Book>> fetchAllBooks()
	{
		return new ResponseEntity<>(service.fetchAll(), HttpStatus.OK);
	}
	
	@PostMapping(value="/create",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> addBook(@RequestBody Book book)
	{
		return new ResponseEntity<>(service.saveBook(book), HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Integer id)
	{
		service.deleteBookId(id);
		return new ResponseEntity<Void>( HttpStatus.OK);
	}
}
