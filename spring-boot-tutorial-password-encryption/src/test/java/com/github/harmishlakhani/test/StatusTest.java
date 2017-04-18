package com.github.harmishlakhani.test;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

import java.util.Calendar;

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
		//System.out.println("Before DB Save : " + status.getAdded().getTime());
		assertNotNull("Non-null ID", status.getId());
		assertNotNull("Non-null Date", status.getAdded());
		StatusUpdate retrived = statusUpdateRepository.findOne(status.getId());
		//System.out.println("After DB Save : " + retrived.getAdded().getTime());
		assertEquals("Matching StatusUpdate", status, retrived);
	}
	
	@Test
	public void testFindLatest() {
		Calendar calendar = Calendar.getInstance();
		StatusUpdate latest = null;
		
		for(int i = 0; i < 5; i++) {
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			StatusUpdate status = new StatusUpdate("Status Update " + i, calendar.getTime());
			statusUpdateRepository.save(status);
			latest = status;
		}
		
		StatusUpdate retrived = statusUpdateRepository.findFirstByOrderByAddedDesc();
		assertEquals("LAtest StatusUpdate", latest, retrived);
	}
}
