package com.moelife.moonlight.bookservice.book;


import javax.persistence.*;

import com.moelife.moonlight.bookservice.author.Author;
import com.moelife.moonlight.bookservice.model.BaseEntity;
import lombok.*;

@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
@AttributeOverride(name = "id", column = @Column(name = "book_author_id"))
public class BookAuthor extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "author_id")
	private Author author;

	@Convert(converter = AuthorType.Converter.class)
	private AuthorType authorType;

	@Builder
	BookAuthor(Book book, Author author, AuthorType authorType) {
		this.book = book;
		this.author = author;
		this.authorType = authorType;
	}

	public long getId() {
		return author.getId();
	}

	public String getName() {
		return author.getName();
	}

	public AuthorType getType() {
		return authorType;
	}
}
