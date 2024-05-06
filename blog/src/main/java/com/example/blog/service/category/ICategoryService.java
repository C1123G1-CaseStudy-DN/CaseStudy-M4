package com.example.blog.service.category;

import com.example.blog.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> finCaatwtegory();

    Optional<Category> findById(Integer id);
}
