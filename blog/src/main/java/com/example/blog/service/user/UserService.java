package com.example.blog.service.user;

import com.example.blog.model.User;
import com.example.blog.repository.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

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
