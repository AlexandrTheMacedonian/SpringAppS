package ua.alex.SpringApp.service;

/**
 *
 */
public interface SecurityService {

    String findLoggedInUsername();
    void autoLogin(String username, String password);
}
