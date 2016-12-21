package com.example.me.KAMMZ;

import detail.*;
import other.*;
import user.*;

/**
 * Created by Mona on 12/9/2016.
 */

public class UserFactory extends ClinicFactory {
    @Override
    public User getUser(String u){
        if (u==null)
            return null;
        if(u.equalsIgnoreCase("Doctor"))
            return new Doctor();
        if(u.equalsIgnoreCase("Patient"))
            return new Patient();
        if(u.equalsIgnoreCase("Secretary"))
            return new Secretary();
         return null;
    }
    @Override
    public Detail getDetail(String d){
        return null;
    }
    @Override
    public Other getOther(String o){
        return null;
    }

}
