package com.github.harmishlakhani.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.github.harmishlakhani.App;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@WebAppConfiguration
public class StatusTest {

	@Test
	public void testDummy() {
		Long value = 100L;
		
		Assert.assertNotNull("Value should not be Null!!", value);
	}
}
