package com.example.blog.service.roles;

import com.example.blog.repository.roles.IRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesService implements IRolesService {
    @Autowired
    private IRolesRepository iRolesRepository;

    @Override
    public Object getAll() {
        return iRolesRepository.findAll();
    }
}
