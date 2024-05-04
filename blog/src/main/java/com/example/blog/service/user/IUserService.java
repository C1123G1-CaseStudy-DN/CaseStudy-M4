package com.example.blog.service.user;

import com.example.blog.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {
    List<User> getAllBlog();

    void saveUser(User user);

    void deleteUser(Integer id);

    User getUserById(Integer id);

    Page<User> getUsers(int page, int size);

    Page<User> findByName(String key, Pageable pageable);
}
