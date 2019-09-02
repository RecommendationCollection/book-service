package com.moelife.moonlight.bookservice.book;

import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.moelife.moonlight.bookservice.bookauthor.BookAuthor;
import com.moelife.moonlight.bookservice.model.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
@AttributeOverride(name = "id", column = @Column(name = "book_id"))
public class Book extends BaseEntity {

	@Column(nullable = false)
	private String isbn;

	@Column(nullable = false)
	private String isbn13;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private long publishDate;

	@Column(nullable = false)
	private String thumbnail = "";

	@Column(nullable = false)
	private String cover = "";

	@OneToMany(mappedBy = "book")
	private List<BookAuthor> bookAuthors;
}
