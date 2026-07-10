package com.example.employe8;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employe8")
public class employecontroller {
    @Autowired
   private employeserver employeserver;
    @GetMapping("/fetch")
    public List<employe8>getemployedetails()
    {
        return employeserver.getemployedetails();
    }
    @GetMapping("/fetch/{id}")
    public employe8 getemployedetailsbyid(@PathVariable int id)
    {
        return employeserver.getemployedetailsbyid(id);
    }

    @PostMapping("/insert")

    public employe8 insertdata( @RequestBody employe8 employe8)
    {
        return employeserver.insertdata(employe8 );
    }


    @PutMapping("/update/{id}")
    public employe8 updatedata(@PathVariable int id,@RequestBody employe8 employe9)
    {
        return employeserver.updatedata(id,employe9);
    }
    @DeleteMapping("/delete/{id}")
    public String deletedata(@PathVariable int id)
    {
        return employeserver.deletedata(id);
    }

}





