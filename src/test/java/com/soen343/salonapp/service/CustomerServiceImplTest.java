package com.soen343.salonapp.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerServiceImplTest {

    @Mock
    CustomerService customerService;

    @Test
    public void test() {
        System.out.println(customerService);
    }
}
