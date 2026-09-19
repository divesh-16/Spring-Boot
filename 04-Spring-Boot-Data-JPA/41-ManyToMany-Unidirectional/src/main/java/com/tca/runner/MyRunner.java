package com.tca.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tca.entity.Author;
import com.tca.entity.Book;
import com.tca.service.BookService;

@Component
public class MyRunner implements ApplicationRunner
{
	@Autowired
	BookService bookService;
	
	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception 
	{
/*	
		Book book = new Book();
		book.setBid(3L);
		book.setBookName("DDLG");
		
		Author a1 = new Author();
		a1.setAid(104L);
		a1.setAuthorName("Karan");
		
		Author a2 = new Author();
		a2.setAid(105L);
		a2.setAuthorName("Varun");
		
		List<Author> L = Arrays.asList(a1,a2);
		
		book.setAuthors(L);
		
		bookService.saveBook(book);
		System.out.println("Book saved with id  :"+book.getBid());
*/
/*		
		// fetch
		Book book = bookService.fetchById(1L);
		System.out.println("Book ID   : "+book.getBid());
		System.out.println("Book Name : "+book.getBookName());
		System.out.println("=".repeat(50));
		
		List<Author> authors = book.getAuthors();
		
		for(Author a : authors)
		{
			System.out.println("Author Id   : "+a.getAid());
			System.out.println("Author Name : "+a.getAuthorName());
			System.out.println("-".repeat(50));
		}
*/
		// delete
		bookService.removeBook(3L);
		
		
	}
}
