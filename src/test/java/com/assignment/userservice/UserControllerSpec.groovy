package com.assignment.userservice

import org.springframework.ui.Model

import com.assignment.userservice.controller.UserController
import com.assignment.userservice.domain.UserDb

import spock.lang.Specification

class UserControllerSpec extends Specification {
	
	
	UserController userController = new UserController(new UserDb());
	
	
	def 'show users list'() {
		when : 'users list method called'
		def res = userController.showUserList(Mock(Model.class));
		then: 'check the result'
		assert res == 'users'
	}

}
