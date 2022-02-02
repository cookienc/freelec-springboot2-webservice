package com.kookiedncream.book.springboot.web.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HelloResponseDtoTest {

	@DisplayName("롬복 기능 테스트")
	@Test
	void 롬복_기능_테스트() {
		//given
		String name = "test";
		int amount = 1000;

		//when
		HelloResponseDto dto = new HelloResponseDto(name, amount);

		//then
		assertThat(dto.getName()).isEqualTo(name);
		assertThat(dto.getAmount()).isEqualTo(amount);
	}


}