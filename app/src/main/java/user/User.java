package user;

import java.util.Date;

/**
 * Created by me on 12/3/2016.
 */

public  class User {
    private String First;
    private String Last;
    private int Id;
    private Date DOB;
    private String User;
    private String Password;
    private String Tel;
    public User(){
        this("","","","",null,0);

    }
    public User(String First,String Last,String User,String Password,Date DOB,int ID){
        this.First=First;
        this.Last=Last;
        this.Password=Password;
        this.DOB=DOB;
        this.Id=ID;
        this.User=User;
    }
    public int getId(){
        return Id;
    }
    public void setId(int ID){
        this.Id=ID;
    }
    public String getFirst(){
        return First;
    }
    public void setFirst(String name){
        this.First=name;
    }
    public String getLast(){
        return Last;
    }
    public void setLast(String name){
        this.Last=name;
    }
    public String getTel(){
        return Tel;
    }
    public void setTel(String name){
        this.Tel=name;
    }

    public String getUser(){
        return User;
    }
    public void setUser(String Uname){
        this.User= Uname;
    }
    public String getPass(){
        return Password;
    }
    public void setPass(String name){
        this.Password=name;
    }
    public Date getDOB(){
        return (Date) DOB.clone();
    }
    public void setDOB(Date DOB){
        this.DOB=DOB;
    }

}
