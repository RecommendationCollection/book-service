package com.moelife.moonlight.bookservice.book.support;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 외부 사이트(yes24, 알라딘)의 책 정보를 추상화한 인터페이스
 */
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
		public String getLink() {
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

	String getLink();

	List<AuthorInformation> getAuthorInformations();
}
