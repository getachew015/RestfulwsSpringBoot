package com.dagim.restfulWs.RestfulwsSpringBoot.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dagim.restfulWs.RestfulwsSpringBoot.model.User;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	private static Integer userCount = 3;
	static{
		users.add(new User(1,"Brandon", new Date()));
		users.add(new User(2,"Raymond", new Date()));
		users.add(new User(3,"Brook", new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findUser(int id){
		for (User user : users) {
			if(user.getId()==id)
				return user;
		}
		return null;
	}
	
	public User addUser(User user){
		if(user.getId()==null)
			user.setId(++userCount);
		users.add(user);
		return user;
	}
	
	public User deleteUser(int id){
		Iterator<User> iterator = users.iterator();
		
		while(iterator.hasNext()){
			User user = iterator.next();
			if(user.getId()==id)
				users.remove(user);
			return user;
		}
		return null;
	}
}
