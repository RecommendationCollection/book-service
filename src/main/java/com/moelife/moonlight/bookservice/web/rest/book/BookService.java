package com.moelife.moonlight.bookservice.web.rest.book;

import java.util.Optional;

import com.moelife.moonlight.bookservice.author.Author;
import com.moelife.moonlight.bookservice.author.AuthorRepository;
import com.moelife.moonlight.bookservice.book.Book;
import com.moelife.moonlight.bookservice.book.BookBuilder;
import com.moelife.moonlight.bookservice.book.BookInformationManager;
import com.moelife.moonlight.bookservice.book.BookRepository;
import com.moelife.moonlight.bookservice.book.support.AuthorInformation;
import com.moelife.moonlight.bookservice.book.support.BookInformation;

import org.springframework.stereotype.Service;

@Service
public class BookService {

	private final BookRepository bookRepository;

	private final AuthorRepository authorRepository;

	private final BookInformationManager bookInformationManager;

	public BookService(BookRepository bookRepository, AuthorRepository authorRepository, BookInformationManager bookInformationManager) {
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
		this.bookInformationManager = bookInformationManager;
	}

	Book getFromUrl(String url) {
		BookInformation bookInformation = bookInformationManager.getInformation(url);

		return findOrSaveBook(bookInformation);
	}

	private Book findOrSaveBook(BookInformation bookInfo) {
		Book book;
		Optional<Book> find = bookRepository.findByIsbn(bookInfo.getIsbn());

		if (find.isPresent()) {
			book = find.get();
		} else {
			Book newBook = createBook(bookInfo);
			book = bookRepository.save(newBook);
		}

		return book;
	}

	private Book createBook(BookInformation bookInfo) {
		BookBuilder builder = Book.builder().information(bookInfo);

		for (AuthorInformation authorInfo : bookInfo.getAuthorInformations()) {
			builder.addAuthor(findOrSaveAuthor(authorInfo.getName()), authorInfo.getType());
		}

		return builder.build();
	}

	private Author findOrSaveAuthor(String name) {
		Author author;
		Optional<Author> find = authorRepository.findByName(name);

		if (find.isPresent()) {
			author = find.get();
		} else {
			Author newAuthor = Author.of(name);
			author = authorRepository.save(newAuthor);
		}

		return author;
	}
}
