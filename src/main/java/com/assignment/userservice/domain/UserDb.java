package com.assignment.userservice.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class UserDb {

	public List<User> users = new ArrayList<>();
	
	public List<User> fetchAllUsersWithAtleastSalAndAge(int salary, int age){
		List<User> filteredUsers = users.stream().
				filter(user -> user.occupation.salary > salary && user.age >= age).
				collect(Collectors.toList());
		return filteredUsers;
	}
	
	public List<User> fetchUsersByName(String name){
		List<User> filteredUsers = users.stream().
				filter(user -> user.name.equals(name)).
				collect(Collectors.toList());
		return filteredUsers;
	}
	
	public List<User> fetchUsers(){
		return users;
	}
	
	public void addUser(String name, int age, String title, int salary){
		User user = new User();
		user.age = age;
		user.name = name;
		Occupation occupation = new Occupation();
		occupation.salary = salary;
		occupation.title = title;
		user.occupation = occupation;
		users.add(user);
	}
	

}
