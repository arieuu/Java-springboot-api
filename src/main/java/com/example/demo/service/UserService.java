package com.example.demo.service;

import com.example.demo.api.model.User;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> userList;

    public UserService() {
        userList = new ArrayList<>();

        User user1 = new User(1, "Ida", 23, "ida@mail.com");
        User user2 = new User(2, "John", 32, "John@mail.com");

        userList.addAll(Arrays.asList(user1, user2));
    }

    // Optional because there might not be a user with that id

    public Optional<User> getUser(Integer id) {
        Optional optional = Optional.empty();

        for(User user: userList) {
            if(id == user.getId()) {
                optional = Optional.of(user);
                return optional;
            }
        }

        return optional;
    }
}
