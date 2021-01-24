package kz.attractorschool.moviereviewrr.controllers;

import kz.attractorschool.moviereviewrr.model.User;
import kz.attractorschool.moviereviewrr.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/getUserByMail/userMail")
    private User getUserMail(@RequestParam("userMail") String userMail){
        return userService.findUserByEmail(userMail);
    }

    @GetMapping("/users")
    private List<User> userList() {
        return userService.getAllUsers();
    }

    @GetMapping("/findUserByName")
    private User userList(@RequestParam("userName") String userName) {
        return userService.findUserByName(userName);
    }
}
