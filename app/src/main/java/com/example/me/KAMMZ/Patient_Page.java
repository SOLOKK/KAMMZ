package com.example.me.KAMMZ;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Sqllite.DBController;
import user.User;

/**
 * Created by Mona on 12/11/2016.
 */

public class Patient_Page extends AppCompatActivity {
    private ListView lv;
    private DBController DBCont;
    private ArrayList<ArrayList<String>> l;
    private UserArrayAdapter adapter;
    private ArrayList<User> p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_page);
        DBCont=new DBController(this);

        p= DBCont.getAllUsers("patient","Id");


        lv = (ListView)findViewById (R.id.listp);
        lv.setFastScrollEnabled(true);

        adapter =new UserArrayAdapter(this,p);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                User u = adapter.getUser().get(position);

                Toast.makeText(getApplicationContext(),u.getPass(), Toast.LENGTH_SHORT).show();
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
        ArrayList<String> temp;
        adapter.clear();

        switch (item.getItemId()) {

            case R.id.First_Name:
                p=DBCont.getAllUsers("patient","First");
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
                adapter =new UserArrayAdapter(this,p);
                lv.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                return true;

            case R.id.Last_Name:
                p=DBCont.getAllUsers("patient","Last");
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
                adapter =new UserArrayAdapter(this,p);
                lv.setAdapter(adapter);
                adapter.notifyDataSetChanged();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
