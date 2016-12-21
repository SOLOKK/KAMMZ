package user;

import java.util.Date;

/**
 * Created by Mona on 12/9/2016.
 */

public class Secretary extends User {
    public Secretary(){
        super();
    }

    public Secretary(String First, String Last, String Password, String User, Date DOB, int ID){
        super(First,Last,Password,User,DOB,ID);
    }
}
