package com.tca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tca.entity.Author;
import com.tca.repository.AuthorRepository;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService 
{
	@Autowired
	AuthorRepository authorRepository;
	
	@Override
	public Author saveAuthor(Author author) 
	{
		return authorRepository.save(author);
	}

	@Override
	public Author fetchById(Long aid) 
	{
		return authorRepository.findById(aid).get();
	}

	@Override
	public void removeAuthor(Long aid) 
	{
		authorRepository.deleteById(aid);
	}

}
