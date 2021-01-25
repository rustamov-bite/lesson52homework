package kz.attractorschool.moviereviewrr.service;

import kz.attractorschool.moviereviewrr.model.User;
import kz.attractorschool.moviereviewrr.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(String id) {
        return userRepository.findUserById(id);
    }

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public User findUserByName(String name) {
        return userRepository.findUserByName(name);
    }
}
