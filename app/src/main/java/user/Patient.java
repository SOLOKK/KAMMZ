package user;

import java.util.Date;

/**
 * Created by me on 12/3/2016.
 */

public class Patient extends User {
    public Patient(){
        super();

    }
    public Patient(String First,String Last,String Password,String User,Date DOB,int ID){
        super(First,Last,Password,User,DOB,ID);
    }
}

