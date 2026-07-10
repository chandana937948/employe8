package com.example.employe8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class employeserver {
    @Autowired
    employerepo employerepo;



    public List<employe8> getemployedetails()
    {
        return employerepo.findAll();
    }

    public employe8 getemployedetailsbyid(int id) {
        return employerepo.findById(id).orElse(null);
    }
    public employe8 insertdata(@RequestBody employe8 employe8) {
        return employerepo.save(employe8);
    }

    public employe8 updatedata(int id, employe8 employe9) {
        employe8 r= employerepo.findById(id).orElse(null);
        r.setName(employe9.getName());
        r.setRole (employe9.getRole());
        return employerepo.save(r);

    }
    public String deletedata(int id) {
        employerepo.deleteById(id);
        return "data deleted successfully";
    }



}
