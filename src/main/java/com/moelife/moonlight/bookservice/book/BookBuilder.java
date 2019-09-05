package com.moelife.moonlight.bookservice.book;

import java.time.LocalDate;

import com.moelife.moonlight.bookservice.author.Author;
import com.moelife.moonlight.bookservice.book.support.BookInformation;

public class BookBuilder {

	private Book book = new Book();

	public BookBuilder isbn(String isbn) {
		book.setIsbn(isbn);
		return this;
	}

	public BookBuilder title(String title) {
		book.setTitle(title);
		return this;
	}

	public BookBuilder publishDate(LocalDate date) {
		book.setPublishDate(date);
		return this;
	}

	public BookBuilder thumbnail(String thumbnail) {
		book.setThumbnail(thumbnail);
		return this;
	}

	public BookBuilder cover(String cover) {
		book.setCover(cover);
		return this;
	}

	public BookBuilder link(String link) {
		book.setLink(link);
		return this;
	}

	/**
	 * BookInformation 에서 book 과 관련된 정보만 가져오는 메소드
	 * 작가는 따로 추가를 해야함
	 */
	public BookBuilder information(BookInformation information) {
		isbn(information.getIsbn());
		title(information.getTitle());
		publishDate(information.getPublishDate());
		thumbnail(information.getThumbnail());
		cover(information.getCover());

		return this;
	}

	public BookBuilder addAuthor(Author author, AuthorType type) {
		book.addAuthor(author, type);
		return this;
	}

	public Book build() {
		return book;
	}
}
