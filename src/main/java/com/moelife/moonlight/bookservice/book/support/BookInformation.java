package com.moelife.moonlight.bookservice.book.support;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface BookInformation {

	BookInformation NONE = new BookInformation() {
		@Override
		public String getIsbn() {
			return "";
		}

		@Override
		public String getTitle() {
			return "";
		}

		@Override
		public LocalDate getPublishDate() {
			return LocalDate.now();
		}

		@Override
		public String getThumbnail() {
			return "";
		}

		@Override
		public String getCover() {
			return "";
		}

		@Override
		public List<AuthorInformation> getAuthorInformations() {
			return new ArrayList<>();
		}
	};

	String getIsbn();

	String getTitle();

	LocalDate getPublishDate();

	String getThumbnail();

	String getCover();

	List<AuthorInformation> getAuthorInformations();
}
