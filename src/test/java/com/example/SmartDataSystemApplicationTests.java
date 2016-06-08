package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fissionlabs.SmartDataSystemApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SmartDataSystemApplication.class)
@WebAppConfiguration
public class SmartDataSystemApplicationTests {

	@Test
	public void contextLoads() {
	}

}
