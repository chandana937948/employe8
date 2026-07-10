package com.example.employe8;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepo extends JpaRepository<Users,Integer> {
    Users findByname(String name);

}
