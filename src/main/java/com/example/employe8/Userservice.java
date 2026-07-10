package com.example.employe8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Userservice implements UserDetailsService {
    @Autowired
    Userrepo userrepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
    Users obj2=userrepo.findByname(username);
    return new UsersDetails1(obj2);


    }

    public Users insertdata(Users users) {
        return userrepo.save(users);
    }

    public List<Users> getuserdetails() {
        return userrepo.findAll();
    }
}
