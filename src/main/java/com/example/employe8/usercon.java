package com.example.employe8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class usercon {
    @Autowired
     Userservice userservice;
    @PostMapping("/insert")

    public Users insertdata( @RequestBody Users users)
    {
        return userservice.insertdata(users);
    }
    @GetMapping("/fetch")
    public List<Users> geteusersdetails()
    {
        return userservice.getuserdetails();
    }


}
