package com.example.me.KAMMZ;

import detail.*;
import other.*;
import user.*;

/**
 * Created by Mona on 12/9/2016.
 */

public class OtherFactory extends ClinicFactory {
    @Override
    public User getUser(String u){
        return null;
    }
    @Override
    public Detail getDetail(String d){
        return null;
    }
    @Override
    public Other getOther(String o){
        if (o==null)
            return null;
        if(o.equalsIgnoreCase("All_For_Pat"))
            return new All_For_Pat();
        if(o.equalsIgnoreCase("Confirm"))
            return new Confirm();
        if(o.equalsIgnoreCase("Dis_For_Pat"))
            return new Dis_For_Pat();
        if(o.equalsIgnoreCase("Med_For_Pat"))
            return new Med_For_Pat();
        if(o.equalsIgnoreCase("Profile"))
            return new Profile();
        if(o.equalsIgnoreCase("Request"))
            return new Request();
        if(o.equalsIgnoreCase("Result"))
            return new Result();
        if(o.equalsIgnoreCase("Speciality"))
            return new Speciality();
        return null;
    }
}
