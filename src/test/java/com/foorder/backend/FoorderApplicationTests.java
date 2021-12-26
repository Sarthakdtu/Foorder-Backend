package com.foorder.backend;

import com.foorder.controller.v1.api.CityController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FoorderApplicationTests {
	@Autowired
	CityController cityController;

	@Test
	void contextLoads() {
		assertThat(cityController).isNotNull();
	}

}
