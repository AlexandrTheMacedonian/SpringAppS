package ua.alex.springApp.service;


import ua.alex.springApp.model.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
