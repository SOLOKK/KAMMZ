package com.example.me.KAMMZ;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Sqllite.DBController;
import user.Doctor;

/**
 * Created by Mona on 12/13/2016.
 */

public class Doctor_Profile extends AppCompatActivity {
    DBController DBCont;
    ListView lv;
    ArrayAdapter<String> adapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor_profile);
        DBCont = new DBController(this);
        //ArrayList<String> a= DBCont.getDoc(getIntent().getIntExtra("Id",1));
        String a= DBCont.getDoc(getIntent().getIntExtra("Id",1));
        ArrayList<String> b= new ArrayList<String>();

        ArrayList<String> spec=DBCont.getSpec(Integer.parseInt(a));

        b.add(getIntent().getStringExtra("First"));
        b.add(getIntent().getStringExtra("Last"));
        b.add(getIntent().getStringExtra("DOB"));
        b.add(spec.get(0));
        b.add(spec.get(1));
        System.out.println(b.toString());
        lv = (ListView)findViewById (R.id.listp);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1,b);
        lv.setAdapter(adapter);
    }
}
