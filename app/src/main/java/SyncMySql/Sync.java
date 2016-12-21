package SyncMySql;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.me.KAMMZ.MySingleton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import user.User;

/**
 * Created by Mona on 12/10/2016.
 */

public class Sync {
    private Context ctx;
    private JSONObject j;

    public JSONObject getJ() {
        return j;
    }

    public void setJ(JSONObject j) {
        this.j = j;
    }

    public Sync(Context ctx){
        this.ctx=ctx;
    }
    public JSONObject syncSQLiteMySQLDB() {

        String url = "http://10.0.2.2/clinic/test.php";
        Response<JSONObject> r;
        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public JSONObject onResponse(JSONObject response) {
                        // the response is already constructed as a JSONObject!

                        updateSQLite(response);

                        return response;



                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });

        //Volley.newRequestQueue(this).add(jsonRequest);
        MySingleton.getInstance(ctx).addToRequestQueue(jsonRequest);
        return null;

    }
    public ArrayList<User> getAllUser(JSONObject js){
        return null;

    }

    public void updateSQLite(JSONObject response){
        j=response;
        System.out.println("update sql");

        Gson gson = new GsonBuilder().create();
        try {

            System.out.println(getJ().get("Id").toString());
            System.out.println(getJ().get("Name").toString());
            Toast.makeText(ctx,j.toString(), Toast.LENGTH_LONG).show();

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
