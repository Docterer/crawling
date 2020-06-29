package com.movie.crawling;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrawlingApplicationTests {

	@Autowired
	StringEncryptor stringEncryptor;

	@Test
	public void contextLoads() {
		String result = stringEncryptor.encrypt("yourpassword");
		System.out.println("==================");
		System.out.println(result);
		System.out.println("==================");
	}

}
