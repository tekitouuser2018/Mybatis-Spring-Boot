package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.demo.service.BookServiceImpl;

@Configuration
@ComponentScan("com.example.demo.service")
//@MapperScan("com.example.demo.mapper.BookMapper")
public class DataConfiguration {


	@Bean
	public BookServiceImpl bookServiceImpl() {
		return new BookServiceImpl();
	}


}
