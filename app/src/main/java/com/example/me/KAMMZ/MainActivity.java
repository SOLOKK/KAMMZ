package com.example.me.KAMMZ;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONObject;

import java.util.ArrayList;

import Sqllite.DBController;
import SyncMySql.Sync;
import user.User;


public class MainActivity extends AppCompatActivity {
    DBController DBCont;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);


        ImageView p = (ImageView) findViewById(R.id.p);

        p.setOnClickListener(
                new ImageView.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Patient_Page.class);
                        startActivity(intent);
                    }
                }
        );



        ImageView d = (ImageView) findViewById(R.id.d);

        d.setOnClickListener(
                new ImageView.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Doctor_Page.class);
                        startActivity(intent);
                    }
                }
        );

        Sync s=new Sync(this);
        s.syncSQLiteMySQLDB();

        //DBCont = new DBController(this);
        //SQLiteDatabase database = DBCont.getWritableDatabase();
        //this.deleteDatabase("clinic.db");

        //database.execSQL("delete from patient ");
        //DBCont.put(DBCont);
        //DBCont.putspec(DBCont);
        //database.execSQL("delete from doctor ");
        //DBCont.putd(DBCont);


        /*ArrayList<User> u = DBCont.getAllUsers("patient", "First");
        System.out.println("Patients" + u);*/


        /*for(int i=0;i<5;i++){
            System.out.println(u.get(i).getId());
            System.out.println(u.get(i).getFirst());
            System.out.println(u.get(i).getDOB());

        }*/




       /* ArrayList<User> ud = DBCont.getAllUsers("doctor", "First");
        System.out.println("Doctors" +ud);*/

        /*for(int i=0;i<5;i++){
            System.out.println(ud.get(i).getId());
            System.out.println(ud.get(i).getFirst());
            System.out.println(ud.get(i).getDOB());

        }*/


    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);


        return true;
    }
    public void reloadActivity(){
        Intent objIntent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(objIntent);
    }
}





