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
import com.tca.service.AuthorService;
import com.tca.service.BookService;

@Component
public class MyRunner implements ApplicationRunner
{
	@Autowired
	BookService bookService;
	
	@Autowired
	AuthorService authorService;
	
	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception 
	{
	
		// In bi-direction setting entity for both is mandatory
		// i.e set Book for author (a1.setBooks(Arrays.asList(b1,b2)))  and set Author for book (b1.setAuthors(List.of(a1)))
		
		Author a1 = new Author();
		a1.setAid(103L);
		a1.setAuthorName("Jaran");
		
		Book b1 = new Book();
		b1.setBid(1L);
		b1.setBookName("Java");
		b1.setAuthors(List.of(a1));
		
		Book b2 = new Book();
		b2.setBid(2L);
		b2.setBookName("Hibernate");
		b2.setAuthors(List.of(a1));
				
		a1.setBooks(Arrays.asList(b1,b2));
		authorService.saveAuthor(a1);
	
	
/*	
		// fetch
		Author a = authorService.fetchById(101L);
		System.out.println("Author Id   : "+a.getAid());
		System.out.println("Author Name : "+a.getAuthorName());
		System.out.println("-".repeat(50));
		
		List<Book> books = a.getBooks();
		
	
		for(Book book : books)
		{
			System.out.println("Book ID   : "+book.getBid());
			System.out.println("Book Name : "+book.getBookName());
			System.out.println("=".repeat(50));
		}
*/
/*		

		// delete
		//bookService.removeBook(2L);	-> error
		authorService.removeAuthor(103L);
		
		// Note In bi-direction the Owning side can only delete the it's own entity, 
		//if inverse side tries to delete then it gets below Exception
		//DataIntegrityViolationException: could not execute statement [Cannot delete or update a parent row: a foreign key constraint fails (`springboot`.`book_author`, CONSTRAINT `FKhwgu59n9o80xv75plf9ggj7xn` FOREIGN KEY (`book_id`) REFERENCES `book` (`bid`))] [delete from book where bid=?]; SQL [delete from book where bid=?]; constraint [FKhwgu59n9o80xv75plf9ggj7xn]
*/	
	
	}
	
}
