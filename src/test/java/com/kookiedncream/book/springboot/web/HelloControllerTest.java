package com.kookiedncream.book.springboot.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(HelloController.class)
class HelloControllerTest {

	@Autowired
	private MockMvc mvc;

	@DisplayName("hello가 리턴됨")
	@Test
	void hello() throws Exception {
	    //given
		String hello = "hello";

	    //when

	    //then
		mvc.perform(get("/hello"))
				.andExpect(status().isOk())
				.andExpect(content().string(hello));
	}

	@DisplayName("helloDto가 리턴")
	@Test
	void helloDto() throws Exception {
	    //given
		String name = "hello";
		int amount = 1000;

		//when

	    //then
		mvc.perform(get("/hello/dto")
						.param("name", name)
						.param("amount", String.valueOf(amount)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name", is(name)))
				.andExpect(jsonPath("$.amount", is(amount)));
	}
}