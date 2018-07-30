package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {


	private Long id;

	private String title;

	public Book() {}

	public Book(String title){
		this.title = title;
	}


}
