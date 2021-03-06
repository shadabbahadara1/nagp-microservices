package com.nagarro.userservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.nagarro.userservice.models.User;
import com.nagarro.userservice.services.UserServiceImpl;
import com.nagarro.userservice.views.Views;

@RestController
@RequestMapping("/user")
public class UserResource {

	@Autowired
	private UserServiceImpl userService;

	@GetMapping(path = "/{userId}")
	@JsonView(Views.Get.class)
	public User getUser(@PathVariable("userId") int userId) {
		return userService.getUser(userId);
	}

	@PostMapping
	@ResponseBody
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
}
