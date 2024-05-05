package com.api.crud.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.crud.models.UserModels;
import com.api.crud.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping
  public ArrayList<UserModels> getUsers() {
    return this.userService.getUsers();
  };

  @PostMapping
  public UserModels saveUser(@RequestBody UserModels user) {
    return this.userService.saveUser(user);
  }

  @GetMapping(path = "/{id}")
  public Optional<UserModels> getUserById(@PathVariable("id") long id) {
    return this.userService.getById(id);
  }

  @PutMapping(path = "/{id}")
  public UserModels updateUserById(@RequestBody UserModels user, @PathVariable("id") long id) {
    return this.userService.updateById(user, id);
  }

  @DeleteMapping(path = "/{id}")
  public String deleteById(@PathVariable("id") Long id) {
    Boolean ok = this.userService.deleteUser(id);

    if (ok) {
      return "User with id " + id + " was deleted";
    } else {
      return "Something was wrong";
    }
  }
}
