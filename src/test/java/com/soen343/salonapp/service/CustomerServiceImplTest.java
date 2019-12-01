package com.soen343.salonapp.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class CustomerServiceImplTest {

    @Mock
    CustomerService customerService;

    @Test
    public void test() {
        System.out.println(customerService);
    }
}
