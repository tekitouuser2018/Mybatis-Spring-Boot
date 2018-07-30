package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.model.Book;

@Mapper
public interface BookMapper {

	List<Book> getAllBook();

	Book getBookByTitle(String title);

	void insertBook(Book book);

	void updateByTitle(@Param("title")String title,
			@Param("newTitle")String newTitle);

	void deleteAll();

	void deleteByTitle(String title);

}
