package com.tca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tca.entity.Book;
import com.tca.repository.BookRepository;

@Service("bookService")
public class BookServiceImpl implements BookService 
{
	@Autowired
	BookRepository bookRepository;
	
	@Override
	public Book saveBook(Book b) 
	{
		return bookRepository.save(b);
	}

	@Override
	public Book fetchById(Long bid) 
	{
		return bookRepository.findById(bid).get();
	}

	@Override
	public void removeBook(Long bid) 
	{
		bookRepository.deleteById(bid);
	}

}
