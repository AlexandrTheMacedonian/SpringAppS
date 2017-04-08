package ua.alex.SpringApp.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.alex.SpringApp.model.User;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
