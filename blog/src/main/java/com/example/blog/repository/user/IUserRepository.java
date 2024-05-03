package com.example.blog.repository.user;

import com.example.blog.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    Page<User> findAll(Pageable pageable);

//    @Query("SELECT u FROM User u WHERE u.name LIKE %:name%") // Tìm kiếm theo tên
//    List<User> findByNameContaining(@Param("name") String name);
}