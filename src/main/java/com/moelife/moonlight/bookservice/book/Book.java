package com.moelife.moonlight.bookservice.book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.google.common.collect.ImmutableList;
import com.moelife.moonlight.bookservice.author.Author;
import com.moelife.moonlight.bookservice.model.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
@AttributeOverride(name = "id", column = @Column(name = "book_id"))
public class Book extends BaseEntity {

	@Column
	private String isbn;

	@Column(nullable = false)
	private String title;

	@Column
	private LocalDate publishDate;

	@Column
	private String thumbnail = "";

	@Column
	private String cover = "";

	@Column
	private String link = "";

	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.PACKAGE)
	@Cascade(CascadeType.ALL)
	@OneToMany(mappedBy = "book", orphanRemoval = true)
	private List<BookAuthor> bookAuthors = new ArrayList<>();

	public static BookBuilder builder() {
		return new BookBuilder();
	}

	public void addAuthor(Author author, AuthorType type) {
		BookAuthor bookAuthor = BookAuthor.builder()
				.book(this)
				.author(author)
				.authorType(type == null ? AuthorType.NONE : type)
				.build();

		this.bookAuthors.add(bookAuthor);
	}

	public void removeAuthor(Author author) {
		Optional<BookAuthor> bookAuthor = this.bookAuthors.stream()
				.filter(ba -> ba.getAuthor() == author)
				.findFirst();

		bookAuthor.ifPresent(value -> bookAuthors.remove(value));
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
		if (StringUtils.isBlank(cover)) {
			cover = thumbnail;
		}
	}

	public void setCover(String cover) {
		this.cover = cover;
		if (StringUtils.isBlank(thumbnail)) {
			thumbnail = cover;
		}
	}

	public ImmutableList<BookAuthor> getAuthors() {
		return ImmutableList.copyOf(bookAuthors);
	}
}
