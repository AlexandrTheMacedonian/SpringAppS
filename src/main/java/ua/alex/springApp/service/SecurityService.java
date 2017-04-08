package ua.alex.springApp.service;

/**
 *
 */
public interface SecurityService {

    String findLoggedInUsername();
    void autoLogin(String username, String password);
}
