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
        boolean found = false;
        User tmpUser = new User();
        for (User u : userRepository.findAll()) {
            if (u.getEmail().equals(email)) {
                found = true;
                tmpUser = u;
                break;
            }
        }
        if (found) {
            return tmpUser;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public User findUserByName(String name) {
        boolean found = false;
        User tmpUser = new User();
        for (User u : userRepository.findAll()) {
            if (u.getName().toLowerCase().equals(name.toLowerCase())) {
                found = true;
                tmpUser = u;
                break;
            }
        }
        if (found) {
            return tmpUser;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void saveAllUsers(List<User> users) {
        userRepository.saveAll(users);
    }

    public void saveOneUser(User user) {
        userRepository.save(user);
    }

    public void deleteAllUsers(List<User> users) {
        userRepository.deleteAll(users);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
