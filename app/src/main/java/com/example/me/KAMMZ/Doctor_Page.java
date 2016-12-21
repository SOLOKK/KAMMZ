package com.example.me.KAMMZ;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Sqllite.DBController;
import user.Doctor;
import user.User;

/**
 * Created by Mona on 12/12/2016.
 */

public class Doctor_Page extends AppCompatActivity {
    private ListView lv;
    private DBController DBCont;
    private ArrayList<ArrayList<String>> l;
    private UserArrayAdapter adapter;
    private ArrayList<User> d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor_page);
        DBCont=new DBController(this);
        //SQLiteDatabase database = DBCont.getWritableDatabase();
        d= DBCont.getAllUsers("Doctor","Id");

       /* l=new  ArrayList<ArrayList<String>>();
        ArrayList<String> temp;


            for (int j = 0; j < p.size(); j++) {
                temp=new ArrayList<String>();
                temp.add(p.get(j).getFirst());
                temp.add(p.get(j).getLast());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(p.get(j).getDOB());
                temp.add(date);
                l.add(temp);
            }*/
        lv = (ListView)findViewById (R.id.listd);
        lv.setFastScrollEnabled(true);
        // adapter = new ArrayAdapter<ArrayList<String>>(this, android.R.layout.simple_list_item_1,android.R.id.text1,l);
      adapter =new UserArrayAdapter(this, d);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                User u = adapter.getUser().get(position);

                Intent intent = new Intent(getBaseContext(), Doctor_Profile.class);
                intent.putExtra("Id",u.getId());
                intent.putExtra("First",u.getFirst());
                intent.putExtra("Last",u.getLast());

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(u.getDOB());
                intent.putExtra("DOB",date);


                startActivity(intent);

            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.Search);
        SearchView searchView= (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);

                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        adapter.clear();

        switch (item.getItemId()) {

            case R.id.First_Name:
                d=DBCont.getAllUsers("doctor","First");
               /* for (int j = 0; j < p.size(); j++) {
                    temp=new ArrayList<String>();
                    temp.add(p.get(j).getFirst());
                    temp.add(p.get(j).getLast());
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String date = sdf.format(p.get(j).getDOB());
                    temp.add(date);
                    l.add(temp);
                }

                adapter = new ArrayAdapter<ArrayList<String>>(this, android.R.layout.simple_list_item_1,android.R.id.text1,l);*/
                adapter =new UserArrayAdapter(this, d);
                lv.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                return true;

            case R.id.Last_Name:
                d=DBCont.getAllUsers("doctor","Last");
               /* for (int j = 0; j < p.size(); j++) {
                    temp=new ArrayList<String>();
                    temp.add(p.get(j).getFirst());
                    temp.add(p.get(j).getLast());
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String date = sdf.format(p.get(j).getDOB());
                    temp.add(date);
                    l.add(temp);
                }

                adapter = new ArrayAdapter<ArrayList<String>>(this, android.R.layout.simple_list_item_1,android.R.id.text1,l);*/
               adapter =new UserArrayAdapter(this, d);
                lv.setAdapter(adapter);
                adapter.notifyDataSetChanged();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}


