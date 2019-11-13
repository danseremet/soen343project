package com.soen343.salonapp;

import com.soen343.salonapp.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SalonApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void test() {
		Customer c = new Customer("johndoe", "123456", "John", "Doe");
		System.out.println(c);
	}

}
