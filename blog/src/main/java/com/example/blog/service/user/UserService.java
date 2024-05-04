package com.example.blog.service.user;

import com.example.blog.model.User;
import com.example.blog.repository.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;

import java.util.List;
@Configuration
@EnableMethodSecurity
@EnableWebSecurity
@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;
    @Override
    public List<User> getAllBlog() {
        return iUserRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        iUserRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        iUserRepository.deleteById(id);
    }

    @Override
    public User getUserById(Integer id) {
        return iUserRepository.findById(id).get();
    }

    @Override
    public Page<User> getUsers(int page, int size) {
        return iUserRepository.findAll(PageRequest.of(page, size));
    }

}
