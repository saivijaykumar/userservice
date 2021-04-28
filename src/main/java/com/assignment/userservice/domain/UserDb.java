package com.assignment.userservice.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter @Setter
public class UserDb {

	public List<User> users = new ArrayList<>();
	
	public List<User> fetchAllUsersWithAtleastSalAndAge(int salary, int age){
		List<User> filteredUsers = users.stream().
				filter(user -> user.getOccupation().getSalary() > salary && user.getAge() >= age).
				collect(Collectors.toList());
		return filteredUsers;
	}
	
	public List<User> fetchUsersByName(String name){
		List<User> filteredUsers = users.stream().
				filter(user -> user.getName().equals(name)).
				collect(Collectors.toList());
		return filteredUsers;
	}
	
	public List<User> fetchUsers(){
		return users;
	}
	
	public void addUser(String name, int age, String title, int salary){
		User user = new User();
		user.setAge(age);
		user.setName(name);
		Occupation occupation = new Occupation();
		occupation.setSalary(salary);
		occupation.setTitle(title);
		user.setOccupation(occupation);
		users.add(user);
	}
	

}
