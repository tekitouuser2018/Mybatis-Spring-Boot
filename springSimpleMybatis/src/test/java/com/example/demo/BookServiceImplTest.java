package com.example.demo;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.mapper.BookMapper;
import com.example.demo.model.Book;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@SpringApplicationConfiguration(SpringSimpleMybatisApplication.class)
//@MapperScan("com.example.demo.BookMapper")
public class BookServiceImplTest {

	@Autowired
	BookMapper  bookMapper;

	Book testBook;
	String testTitle = "testbook";

	@Before
	public void ready() {
		testBook = new Book(testTitle);
	}

//	@After
//	public void cleanUp() {
//		bookMapper.deleteByTitle(testTitle);
//	}


	@Test
	public void testGetAllBook() {
		List<Book> list = bookMapper.getAllBook();
		Book firstBook = list.get(0);
		String name = firstBook.getTitle();

		assertThat(list.size()).isEqualTo(4);
		assertThat(name).isEqualTo("abc murder");
		assertThat(list.get(1).getId()).isEqualTo(2);
	}

	@Test
	public void testInsertBook() {

		bookMapper.insertBook(testBook);
		Book book = bookMapper.getBookByTitle(testTitle);
		assertThat(book).isNotNull();

	}


	@Test
	public void getBookByTitle() {
		Book book = bookMapper.getBookByTitle("abc murder");
		assertThat(book).isNotNull();

	}

	@Test
	public void updateByTitle() {

		bookMapper.insertBook(testBook);
		bookMapper.updateByTitle(testTitle,"updatedTitle");
		Book book = bookMapper.getBookByTitle("updatedTitle");
		assertThat(bookMapper.getBookByTitle(testTitle)).isNull();
		assertThat(book).isNotNull();
		testTitle = "updatedTitle";
	}


	@Test
	public void deleteByTitle() {
		bookMapper.deleteByTitle(testTitle);
		Book book = bookMapper.getBookByTitle(testTitle);
		assertThat(book).isNull();
	}

//	@Test
//	public void deleteAll() {
//		bookMapper.deleteAll();
//	}

}
