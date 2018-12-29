package com.az.publisher.component;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.az.consumer.model.User;
import com.az.consumer.model.UserCollection;



@Component
public class PublisherComponent implements CommandLineRunner{

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Value("${outbound.endpoint}")
	private String destination;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		List<User> userLsit = null;
		User user = new User();
		user.setUserId(UUID.randomUUID().toString());
		user.setUserName("Malik");
		
		User user1 = new User();
		user1.setUserId(UUID.randomUUID().toString());
		user1.setUserName("Shah");
		
		User user2 = new User();
		user2.setUserId(UUID.randomUUID().toString());
		user2.setUserName("Mughal");
		
		User user3 = new User();
		user3.setUserId(UUID.randomUUID().toString());
		user3.setUserName("Az");
		
		userLsit = Arrays.asList(user,user1,user2,user3);
		
		UserCollection users = new UserCollection();
		users.setUserList(userLsit);
		
		jmsTemplate.convertAndSend(destination, users);
	}

}
