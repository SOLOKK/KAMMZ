package Sqllite;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.Settings;

import other.Other;
import other.Speciality;
import user.Doctor;
import user.Patient;
import user.User;

/**
 * Created by me on 12/3/2016.
 */

public class DBController extends SQLiteOpenHelper {

    public DBController(Context applicationcontext) {
        super(applicationcontext, "clinic.db", null, 1);

    }

    //for creating tables
    @Override
    public void onCreate(SQLiteDatabase database) {
        System.out.println("onCreate for sqlite");
        String query;
        query="CREATE TABLE `speciality` (`Id` integer primary key autoincrement,`Name` varchar(100) NOT NULL,`Description` varchar(200) NOT NULL)";
        database.execSQL(query);

        query="CREATE TABLE `Doctor` (`Id` integer primary key autoincrement,`First` varchar(20) NOT NULL,`Last` varchar(20) NOT NULL,`User` varchar(20) NOT NULL,`Password` varchar(20) NOT NULL,`DOB` date NOT NULL,SID INTEGER,FOREIGN KEY(SID) REFERENCES speciality(Id))";
        database.execSQL(query);

        query="CREATE TABLE `patient` (`Id` integer primary key autoincrement,`First` varchar(20) NOT NULL,`Last` varchar(20) NOT NULL,`User` varchar(20) NOT NULL,`Password` varchar(20) NOT NULL,`DOB` date NOT NULL)";
        database.execSQL(query);





        System.out.println("Tables created");
    }

    //for upgrading tables
    @Override
    public void onUpgrade(SQLiteDatabase database, int version_old, int current_version) {
        String q;
        q= "DROP DATABASE clinic";
        database.execSQL(q);
        onCreate(database);


    }
    public void insertSpec(Speciality spec){

            SQLiteDatabase database = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            //values.put("Id",user.getId());
            values.put("Name",spec.getName());
            values.put("Description",spec.getDescription());
            database.insert("speciality", null, values);
            database.close();
    }


   public void insert(User user, String t) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        //values.put("Id",user.getId());
        values.put("First",user.getFirst());
        values.put("Last",user.getLast());
        values.put("User",user.getUser());
        values.put("Password",user.getPass());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(user.getDOB());
        values.put("DOB",date);
        if(t.equalsIgnoreCase("doctor")){
            Doctor d= (Doctor) user;
            values.put("SID",d.getSID());
        }
        database.insert(t, null, values);
       /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       String date = sdf.format(user.getDOB());
       if (t.equalsIgnoreCase("patient")){
           String q="Insert Into patient (Id,First,Last,User,Password,DOB) values('"+user.getId()+"','"+user.getFirst()+"','"+user.getLast()+"','"+user.getUser()+"','"+user.getPass()+"','"+date+"') ";
           database.execSQL(q);
           System.out.println("Patients are inserted");
       }

       if(t.equalsIgnoreCase("doctor")){
           String q="Insert Into doctor (Id,First,Last,User,Password,DOB) values('"+user.getId()+"','"+user.getFirst()+"','"+user.getLast()+"','"+user.getUser()+"','"+user.getPass()+"','"+date+"') ";
           database.execSQL(q);
           System.out.println("Doctors are inserted");

       }*/

       database.close();
    }
    public void putspec(DBController DBCont) {
        Speciality o=new Speciality(1,"Cardiology","are doctors who specialize in diagnosing and treating diseases or conditions of the heart and blood vessels—the cardiovascular system.");
        DBCont.insertSpec(o);
        Speciality o1=new Speciality(1,"Neurologyy","physician specializing in neurology and trained to investigate, or diagnose and treat neurological disorders.");
        DBCont.insertSpec(o1);
    }
    public void put(DBController DBCont){
        Date d =new Date();

        //Calendar mCalendar = new GregorianCalendar(1994,05,28);
        //Date d1 = mCalendar.getTime();

        User p1= new Patient("Mona","Farhat","mona","mona",d,1);
        DBCont.insert(p1,"patient");


        User p2= new Patient("Amal","Harb","amal","amal",d,2);
        DBCont.insert(p2,"patient");


        User p3= new Patient("Kisra","Al Kadi","kisra","kisra",d,3);
        DBCont.insert(p3,"patient");


        User p4= new Patient("Mohamad","Hashim","mhmd","mhmd",d,4);
        DBCont.insert(p4,"patient");


        User p5= new Patient("Zaher","Haidar","zaher","zaher",d,5);
        DBCont.insert(p5,"patient");

    }

    public void putd(DBController DBCont){
        Date d =new Date();

        User d1= new Doctor("Ali","Taher","ali","ali",d,1,1);
        DBCont.insert(d1,"doctor");

        User d2= new Doctor("Mahmoud","Choukair","mahmoud","mahmoud",d,2,1);
        DBCont.insert(d2,"doctor");

        User d3= new Doctor("Yousef","Rida","yousef","yousef",d,3,1);
        DBCont.insert(d3,"doctor");

        User d4= new Doctor("Joumana","Morad","jojo","jojo",d,4,2);
        DBCont.insert(d4,"doctor");

        User d5= new Doctor("Ali","Sabra","aloush","ali",d,5,2);
        DBCont.insert(d5,"doctor");

    }

    public ArrayList<User> getAllUsers(String table,String order) {
        ArrayList<User> usersList;
        usersList = new ArrayList<User>();
        String selectQuery = "SELECT  * FROM "+table+" ORDER BY "+order;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date d = sdf.parse(cursor.getString(cursor.getColumnIndex("DOB")));
                    int id =cursor.getInt(cursor.getColumnIndex("Id"));
                    User u=new User(cursor.getString(cursor.getColumnIndex("First")),cursor.getString(cursor.getColumnIndex("Last")),cursor.getString(cursor.getColumnIndex("User")),cursor.getString(cursor.getColumnIndex("Password")),d,id);

                        usersList.add(u);

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } while (cursor.moveToNext());
        }
        database.close();
        return usersList;
    }
    public String getDoc(int Id){
        String doc=null ;

        String selectQuery = "SELECT  * FROM Doctor WHERE Id = "+ Id;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {

                    doc=cursor.getInt(cursor.getColumnIndex("SID"))+"";

            } while (cursor.moveToNext());
        }
        database.close();
        return doc;

    }
    public ArrayList<String> getSpec(int SID) {
        ArrayList<String> spec= new ArrayList<>();
        String name;
        String desc;
        String selectQuery = "SELECT  * FROM speciality WHERE ID = "+SID;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {


                    name=cursor.getString(cursor.getColumnIndex("Name"));
                    desc=cursor.getString(cursor.getColumnIndex("Description"));
                    spec.add(name);
                    spec.add(desc);

            } while (cursor.moveToNext());
        }
        database.close();
        return spec;
    }
}