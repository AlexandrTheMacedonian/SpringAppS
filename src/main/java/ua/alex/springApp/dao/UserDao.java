package ua.alex.springApp.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.alex.springApp.model.User;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
