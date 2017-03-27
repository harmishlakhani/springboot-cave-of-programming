package com.github.harmishlakhani.test;

import javax.transaction.Transactional;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.github.harmishlakhani.App;
import com.github.harmishlakhani.model.StatusUpdate;
import com.github.harmishlakhani.model.StatusUpdateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@WebAppConfiguration
@Transactional
public class StatusTest {

	@Autowired
	private StatusUpdateRepository statusUpdateRepository;

	@Test
	public void testSave() {
		StatusUpdate status = new StatusUpdate("This is test Status Update!!");
		statusUpdateRepository.save(status);
		assertNotNull("Non-null ID", status.getId());
		assertNotNull("Non-null Date", status.getAdded());
		StatusUpdate retrived = statusUpdateRepository.findOne(status.getId());
		assertEquals("Matching StatusUpdate", status, retrived);
	}
}
