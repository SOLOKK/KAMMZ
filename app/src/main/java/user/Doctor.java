package user;

import java.util.Date;

/**
 * Created by Mona on 12/9/2016.
 */

public class Doctor extends User {
    private int SID;
    public Doctor(){
        super();
    }
    public Doctor(String First,String Last,String Password,String User,Date DOB,int ID,int SID){
        super(First,Last,Password,User,DOB,ID);
        this.SID=SID;
    }
    public void setSID(int SID){
        this.SID=SID;
    }
    public int getSID(){
        return SID;
    }
}
