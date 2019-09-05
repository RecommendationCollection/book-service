package com.moelife.moonlight.bookservice.author;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

import com.moelife.moonlight.bookservice.model.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
@AttributeOverride(name = "id", column = @Column(name = "author_id"))
public class Author extends BaseEntity {

	@Column(nullable = false)
	private String name;

	private Author(String name) {
		this.name = name;
	}

	public static Author of(String name) {
		return new Author(name);
	}
}
