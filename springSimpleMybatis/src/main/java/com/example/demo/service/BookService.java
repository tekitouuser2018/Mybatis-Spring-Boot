package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Book;

public interface BookService {

	public List<Book> getAllBook();

	public Book getBookByTitle(String title);

	public void insertBook(Book book);

	public void updateByTitle(String title, String newTitle);

	public void deleteAll();

	public void deleteByTitle(String title);
}
