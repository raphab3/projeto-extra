package com.databuilder.com.br.abcdata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AbcdataApplication.class)
@TestPropertySource(locations="classpath:application.properties")
public class AbcdataApplicationTests {

	@Test
	public void contextLoads() {
	}

}
