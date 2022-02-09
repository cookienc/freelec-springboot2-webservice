package com.kookiedncream.book.springboot.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.env.MockEnvironment;

import static org.assertj.core.api.Assertions.assertThat;

class ProfileControllerTest {

	@DisplayName("real profile이 조회")
	@Test
	void realProfile() {
	    //given
		String expectedProfile = "real";
		MockEnvironment env = new MockEnvironment();
		env.addActiveProfile(expectedProfile);
		env.addActiveProfile("oauth");
		env.addActiveProfile("real-db");

		ProfileController controller = new ProfileController(env);

		//when
		String profile = controller.profile();

		//then
		assertThat(profile).isEqualTo(expectedProfile);
	}

	@DisplayName("real_profile이 없으면 첫번째가 조회된다")
	@Test
	void firstReturn() {
	    //given
		String expectedProfile = "oauth";
		MockEnvironment env = new MockEnvironment();

		env.addActiveProfile(expectedProfile);
		env.addActiveProfile("real-db");

		ProfileController controller = new ProfileController(env);

		//when
		String profile = controller.profile();

		//then
		assertThat(profile).isEqualTo(expectedProfile);
	}

	@DisplayName("active profile이 없으면 default가 조회")
	@Test
	void defaultReturn() {
	    //given
		String expectedProfile = "default";
		MockEnvironment env = new MockEnvironment();
		ProfileController controller = new ProfileController(env);

		//when
		String profile = controller.profile();

		//then
		assertThat(profile).isEqualTo(expectedProfile);
	}

}