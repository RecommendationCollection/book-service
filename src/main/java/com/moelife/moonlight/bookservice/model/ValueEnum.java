package com.moelife.moonlight.bookservice.model;

import java.util.stream.Stream;
import javax.persistence.AttributeConverter;
import javax.persistence.Enumerated;

public interface ValueEnum {

	int getValue();

	String getDescription();

	abstract class Converter<T extends Enum<T> & ValueEnum> implements AttributeConverter<T, Integer> {

		private final Class<T> targetClass;

		protected Converter(Class<T> targetClass) {
			this.targetClass = targetClass;
		}

		@Override
		@Enumerated
		public Integer convertToDatabaseColumn(T attribute) {
			return attribute.getValue();
		}

		@Override
		public T convertToEntityAttribute(Integer dbData) {
			return Stream.of(targetClass.getEnumConstants())
					.filter(valueEnum -> valueEnum.getValue() == dbData)
					.findFirst().orElseThrow(() -> new IllegalArgumentException(String.format("%s 클래스에 %d 값이 없습니다.", targetClass.getName(), dbData)));
		}
	}
}
