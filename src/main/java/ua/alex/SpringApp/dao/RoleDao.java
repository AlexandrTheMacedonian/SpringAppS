package ua.alex.SpringApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.alex.SpringApp.model.Role;


public interface RoleDao extends JpaRepository<Role, Long> {
}
