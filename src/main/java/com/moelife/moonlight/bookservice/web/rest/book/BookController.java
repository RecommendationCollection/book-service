package com.moelife.moonlight.bookservice.web.rest.book;

import com.moelife.moonlight.bookservice.book.Book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("v1/books")
public class BookController {

	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping
	public BookResponse getFromUrl(@RequestParam("url") String url) {
		Book book = bookService.getFromUrl(url);
		return BookResponse.of(book);
	}
}
