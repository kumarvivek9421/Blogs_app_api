package com.blog_app_apis;

import com.blog_app_apis.entities.User;
import com.blog_app_apis.repositories.UserRepository;
import com.blog_app_apis.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.client.ExpectedCount;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@SpringBootTest
class BlogAppApisApplicationTests {

	@Autowired
	private UserRepository userRepo;
	@Test
	void contextLoads() {
	}

	@Test
	public void repoTest(){
		String className= this.userRepo.getClass().getName();
		String packageName= this.userRepo.getClass().getPackageName();
		System.out.println(className);
		System.out.println(packageName);
	}

}
