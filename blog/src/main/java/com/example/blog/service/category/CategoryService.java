package com.example.blog.service.category;

import com.example.blog.model.Category;
import com.example.blog.repository.category.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements  ICategoryService{
    @Autowired
    private ICategoryRepository iCategoryRepository;
    @Override
    public List<Category> finCaatwtegory() {
        return iCategoryRepository.findAll();
    }
}
