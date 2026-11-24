package com.tca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tca.entity.Book;
import com.tca.exceptions.BookAlreadyExistsException;
import com.tca.exceptions.BookNotFoundException;
import com.tca.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService 
{
	@Autowired
	BookRepository repo;
	
	@Override
	public Book fetchById(Integer id) 
	{
		Optional<Book> book = repo.findById(id);
		
		if(book.isPresent())
		{
			return book.get();
		}
		else
		{
			throw new BookNotFoundException("Book not found with id : "+id);
		}
	}
	
	

	@Override
	public List<Book> fetchAll() 
	{
		List<Book> books = repo.findAll();
		if(books.isEmpty())
		{
			throw new BookNotFoundException("Books are not present in database");
		}
		else
		{
			return books;
		}
	}

	@Override
	public Book saveBook(Book book) 
	{
		if(repo.existsById(book.getId()))
		{
			throw new BookAlreadyExistsException("Book already exists with id : "+book.getId());
		}
		else
		{
			return repo.save(book);
		}
	}
	
	@Override
	public void deleteBookId(Integer id) 
	{
		if( repo.existsById(id) )
		{
			repo.deleteById(id);
		}
		else
		{
			throw new BookNotFoundException("Book with ID:"+ id + " is not Found !!");
		}
	}
	
	

}
