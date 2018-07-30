package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Book;
import com.example.demo.service.BookServiceImpl;

@Controller
public class BookController {

	@Autowired
	ApplicationContext context;

	@RequestMapping("/")
	public String index(Model model) {
		System.err.println("loading...");
		BookServiceImpl bs = context.getBean(BookServiceImpl.class);
		List<Book> list = bs.getAllBook();
		model.addAttribute("initdata",list);
		return("index");
	}
}
