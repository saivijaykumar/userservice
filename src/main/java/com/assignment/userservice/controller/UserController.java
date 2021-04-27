package com.assignment.userservice.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.userservice.domain.UserDb;

@Controller
public class UserController {

	@Autowired
	private UserDb userDb;
	
	public UserController(UserDb userDb) {
		super();
		this.userDb = userDb;
	}

	public void addUsers(){
		userDb.addUser("sam", 20, "software", 100000);
		userDb.addUser("jessica", 20, "software", 100000);
		userDb.addUser("Dean", 20, "software", 100000);
	}
	
	@GetMapping("/")
    String index(Model model) {
        model.addAttribute("now", LocalDateTime.now());
        return "index";
    }
	
	@GetMapping("/users")
	public String showUserList(Model model) {
		addUsers();
	    model.addAttribute("users", userDb.fetchUsers());
	    return "users";
	}
	
	@PostMapping("/save")
	public String showUserList(@RequestParam("name") String name,@RequestParam("age") int age,
			@RequestParam("title") String title,@RequestParam("salary") int salary, Model model) {
		userDb.addUser(name, age, title, salary);
	    return "index";
	}
}
