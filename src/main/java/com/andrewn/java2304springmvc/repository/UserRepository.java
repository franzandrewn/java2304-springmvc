package com.andrewn.java2304springmvc.repository;

import com.andrewn.java2304springmvc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // находит всех юзеров с определенным возрастом
    List<User> findByAge(int age);

    List<User> findByAgeIn(List<Integer> ages);
}
