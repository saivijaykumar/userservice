package com.assignment.userservice.domain;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
	
	@Size(min = 2, max = 40)
	public String name;
	
	public int age;
	
	public Occupation occupation;
}
