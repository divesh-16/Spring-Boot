package com.tca.service;

import java.util.List;

import com.tca.entity.Book;

public interface BookService
{
	public Book fetchById(Integer id);
	public List<Book> fetchAll();
	public Book saveBook(Book book);
	public void deleteBookId(Integer id);
}
