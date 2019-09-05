package com.moelife.moonlight.bookservice.web.rest.book;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.moelife.moonlight.bookservice.book.AuthorType;
import com.moelife.moonlight.bookservice.book.Book;
import com.moelife.moonlight.bookservice.book.BookAuthor;
import lombok.Getter;

@Getter
class BookResponse {

	private long id;

	private String isbn;

	private String title;

	private LocalDate publishDate;

	private String thumbnail = "";

	private String cover = "";

	private String link = "";

	private List<BookAuthorResponse> authors;

	static BookResponse of(Book book) {
		BookResponse response = new BookResponse();

		response.id = book.getId();
		response.isbn = book.getIsbn();
		response.title = book.getTitle();
		response.publishDate = book.getPublishDate();
		response.thumbnail = book.getThumbnail();
		response.cover = book.getCover();
		response.link = book.getLink();

		response.authors = book.getAuthors().stream()
				.map(BookAuthorResponse::of)
				.collect(Collectors.toList());

		return response;
	}

	@Getter
	private static class BookAuthorResponse {

		private long id;

		private String name;

		private AuthorType type;

		private static BookAuthorResponse of(BookAuthor bookAuthor) {
			BookAuthorResponse response = new BookAuthorResponse();

			response.id = bookAuthor.getId();
			response.name = bookAuthor.getName();
			response.type = bookAuthor.getType();

			return response;
		}
	}
}
