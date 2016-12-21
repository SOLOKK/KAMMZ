package com.example.me.KAMMZ;

import detail.*;
import other.*;
import user.*;

/**
 * Created by Mona on 12/9/2016.
 */

public class DetailFactory extends ClinicFactory {
    @Override
    public User getUser(String u){
        return null;
    }
    @Override
    public Detail getDetail(String d){
        if (d==null)
            return null;
        if(d.equalsIgnoreCase("Medication"))
            return new Medication();
        if(d.equalsIgnoreCase("Allergy"))
            return new Allergy();
        if(d.equalsIgnoreCase("Disease"))
            return new Disease();
         return null;
    }
    @Override
    public Other getOther(String o){
        return null;
    }
}
