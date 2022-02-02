package com.kookiedncream.book.springboot.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostsRepositoryTest {

	@Autowired
	PostsRepository postsRepository;

	@AfterEach
	public void cleanup() {
		postsRepository.deleteAll();
	}

	@DisplayName("게시글 저장 불러오기")
	@Test
	void post() {
		//given
		String title = "테스트 게시글";
		String content = "테스트 본문";

		postsRepository.save(Posts.builder()
				.title(title)
				.content(content)
				.build());

		//when
		List<Posts> postsList = postsRepository.findAll();

		//then
		Posts posts = postsList.get(0);
		assertThat(posts.getTitle()).isEqualTo(title);
		assertThat(posts.getContent()).isEqualTo(content);
	}

	@DisplayName("BaseTimeEntity등록")
	@Test
	void baseTimeEntity() {
	    //given
		LocalDateTime now = LocalDateTime.of(2022, 2, 2, 22, 5, 0);
		postsRepository.save(Posts.builder()
				.title("title")
				.content("content")
				.author("author")
				.build());

	    //when
		List<Posts> postsList = postsRepository.findAll();

		//then
		Posts posts = postsList.get(0);

		System.out.println(">>>>>>>>>>>>>>>> createDate=" + posts.getCreatedDate() +
				", modifiedDate=" + posts.getModifiedDate());

		assertThat(posts.getCreatedDate()).isAfter(now);
		assertThat(posts.getModifiedDate()).isAfter(now);
	}
}