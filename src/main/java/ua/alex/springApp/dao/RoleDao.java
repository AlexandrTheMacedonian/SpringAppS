package ua.alex.springApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.alex.springApp.model.Role;


public interface RoleDao extends JpaRepository<Role, Long> {
}
