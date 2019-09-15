package com.moelife.moonlight.bookservice.book.aladin;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.moelife.moonlight.bookservice.book.AuthorType;
import com.moelife.moonlight.bookservice.book.support.AuthorInformation;
import com.moelife.moonlight.bookservice.book.support.BookInformation;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ArrayUtils;

@Getter
@Setter
public class AladinBookInformation implements BookInformation {

	private String title;

	private String isbn;

	private String isbn13;

	private LocalDate pubDate;

	private String cover;

	private String author;

	private SubInfo subInfo;

	private String link;

	private List<AuthorInformation> authorInformations = new ArrayList<>();

	private static List<AuthorInformation> createAuthorInfo(String aladinAuthor) {
		AuthorType currentType = AuthorType.NONE;

		String[] authors = aladinAuthor.split(", ");
		ArrayUtils.reverse(authors);

		List<AuthorInformation> newAuthorInfos = new ArrayList<>();

		for (String author : authors) {
			currentType = Optional.ofNullable(AladinAuthorInformation.getAuthorType(author))
					.filter(type -> type != AuthorType.NONE).orElse(currentType);

			String name = AladinAuthorInformation.getName(author);
			newAuthorInfos.add(new AladinAuthorInformation(name, currentType));
		}

		return newAuthorInfos;
	}

	@Override
	public String getIsbn() {
		return StringUtils.isNotBlank(isbn13) ? isbn13 : isbn;
	}

	@Override
	public String getTitle() {
		return title.replace(subInfo.subTitle, "")
				.trim()
				.replaceAll(" -$", "");
	}

	@Override
	public LocalDate getPublishDate() {
		return this.pubDate;
	}

	@Override
	public String getThumbnail() {
		return this.cover;
	}

	@Override
	public String getCover() {
		return this.cover.replace("coversum", "cover500");
	}

	@Override
	public List<AuthorInformation> getAuthorInformations() {
		if (this.authorInformations.isEmpty()) {
			this.authorInformations = createAuthorInfo(this.author);
		}
		return this.authorInformations;
	}

	@Override
	public String getLink() {
		return this.link;
	}

	@Getter
	static class SubInfo {
		String subTitle = "";
	}
}
