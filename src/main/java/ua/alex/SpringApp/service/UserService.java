package ua.alex.SpringApp.service;


import ua.alex.SpringApp.model.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
