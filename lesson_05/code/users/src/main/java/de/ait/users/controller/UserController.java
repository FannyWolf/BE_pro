package de.ait.users.controller;

import de.ait.users.entity.User;
import de.ait.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequestMapping("/api")
@RestController
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }


    @PostMapping("/users")
    public User createNewUser(@RequestBody User user){
        return service.createNewUser(user);
    }

    // ПЕРЕДАЧА ИНФОРМАЦИИ В ПАРАМЕТРАХ ЗАПРОСА (query parameters)
    // GET /users?n=jack&email=qwr@rsr&sort=name
    // GET users
    // GET users?n=jack

    @GetMapping("/users")
    public List<User> getUsers(@RequestParam(name = "n", required = false, defaultValue = "") String name,
                               @RequestParam(name = "e", required = false, defaultValue = "") String email){

        return service.getUsers(name, email);
    }


    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id){
        return service.findById(id);
    }


    /*
    ПЕРЕДАЧА ИНФОРМАЦИИ В ПУТИ ЗАПРОСА
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable(name = "id") String strId){
        Long id = Long.valueOf(strId);
        return service.findById(id);
    }
     */

    /*
    user/3/account/4
    @GetMapping("/users/{userID}/account/{accountID}")
    public User getUserById(
                            @PathVariable (name = "userID") Long userId
                            @PathVariable (name = "accountID") Long accId)){
        return service.findById(id);
    }*/

}
