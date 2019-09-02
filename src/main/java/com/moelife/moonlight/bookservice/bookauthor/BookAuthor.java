package com.moelife.moonlight.bookservice.bookauthor;

import javax.persistence.*;

import com.moelife.moonlight.bookservice.author.Author;
import com.moelife.moonlight.bookservice.book.Book;
import com.moelife.moonlight.bookservice.model.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
@AttributeOverride(name = "id", column = @Column(name = "book_author_id"))
public class BookAuthor extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;

	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;

	@Convert(converter = AuthorType.Converter.class)
	private AuthorType authorType;
}
