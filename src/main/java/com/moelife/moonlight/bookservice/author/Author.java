package com.moelife.moonlight.bookservice.author;

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
@AttributeOverride(name = "id", column = @Column(name = "author_id"))
public class Author extends BaseEntity {

	@Column(nullable = false)
	private String name;

	@OneToMany
	private List<BookAuthor> bookAuthors;
}
