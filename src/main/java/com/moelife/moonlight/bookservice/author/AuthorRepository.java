package com.moelife.moonlight.bookservice.author;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

	Optional<Author> findByName(String name);
}
