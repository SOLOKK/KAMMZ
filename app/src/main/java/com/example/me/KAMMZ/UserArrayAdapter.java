package com.example.me.KAMMZ;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import user.User;

/**
 * Created by Mona on 12/12/2016.
 */

public class UserArrayAdapter extends ArrayAdapter<User> implements Filterable{
    private LayoutInflater inflater;
    private ArrayList<User> user;
    private ArrayList<User> origuser;

    private class ViewHolder {
        TextView textView1;
        TextView textView2;
        TextView textView3;

    }


    public UserArrayAdapter(Context context, ArrayList<User> objects) {
        super(context, 0, objects);

        inflater = LayoutInflater.from(context);
        this.user = objects;


    }

    public List<User> getUser() {
        return user;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.view1, null);

            holder.textView1 = (TextView) convertView.findViewById(R.id.First_Name);
            holder.textView2 = (TextView) convertView.findViewById(R.id.Last_Name);
            holder.textView3 = (TextView) convertView.findViewById(R.id.DOB);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView1.setText(user.get(position).getFirst());
        holder.textView2.setText(user.get(position).getLast());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(user.get(position).getDOB());
        holder.textView3.setText(date);
        return convertView;
    }
    @Override
    public int getCount()
    {
        return user.size();
    }
    @Override
    public User getItem (int pos){
        return user.get(pos);
    }
    public Filter getFilter() {

        return new UserFilter();


    }

    class UserFilter extends Filter {
        @Override
        public FilterResults performFiltering(CharSequence text) {
            FilterResults results = new FilterResults();
            // We implement here the filter logic
            if(origuser==null){
                origuser=new ArrayList<User>(user);
            }
            if (text == null || text.length() == 0) {
                // No filter implemented we return all the list
                results.values = origuser;
                results.count = origuser.size();
            } else {
                // We perform filtering operation
                ArrayList<User> list= origuser;
                ArrayList<User> nUser = new ArrayList<User>();

                for (User p : list) {
                    if (p.getFirst().equalsIgnoreCase(text.toString()))
                        nUser.add(p);
                   // if (p.getLast().toUpperCase().startsWith(text.toString().toUpperCase()))
                       // nUser.add(p);
                }

                results.values = nUser;
                results.count = nUser.size();

            }
            return results;
        }
        @Override
        public void publishResults(CharSequence text, FilterResults results) {

            // Now we have to inform the adapter about the new list filtered
            if (results.count == 0)
                notifyDataSetInvalidated();
            else {
                user = (ArrayList<User>) results.values;

                notifyDataSetChanged();
            }

        }

    }

}
