package com.example.demo.service;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.BookMapper;
import com.example.demo.model.Book;

@Service
@MapperScan("com.example.demo.mapper.BookMapper")
public class BookServiceImpl implements BookService{

	@Autowired
	private BookMapper bookMapper;

	@Transactional
	public void insertBook(Book book) {

		try {
			bookMapper.insertBook(book);

		}catch(Exception ex) {
			ex.printStackTrace();

		}

	}


	public List<Book> getAllBook(){
		return bookMapper.getAllBook();
	};



	public Book getBookByTitle(String title) {
		Book book = bookMapper.getBookByTitle(title);
		return book;
	}

	@Transactional
	public void updateByTitle(String title, String newTitle) {

		bookMapper.updateByTitle(title, newTitle);
	}


	public void deleteAll() {
		bookMapper.deleteAll();
	}

	public void deleteByTitle(String title) {
		bookMapper.deleteByTitle(title);
	}



}
