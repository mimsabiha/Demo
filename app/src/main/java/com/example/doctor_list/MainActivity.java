package com.example.doctor_list;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> docNames = new ArrayList<>();
    ArrayList<String> designations = new ArrayList<>();
    ArrayList<String> hospitals = new ArrayList<>();

   // private  ArrayList<DataList>  arrayList;

     RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);


        try {
            // get JSONObject from JSON file
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            // fetch JSONArray named users
            JSONArray userArray = obj.getJSONArray("doc");
            // implement for loop for getting users list data
            for (int i = 0; i < userArray.length(); i++) {
                // create a JSONObject for fetching single user data
                JSONObject userDetail = userArray.getJSONObject(i);
                // fetch email and name and store it in arraylist
                docNames.add(userDetail.getString("name"));
                designations.add(userDetail.getString("designation"));
                hospitals.add(userDetail.getString("medical"));

                // create a object for getting contact data from JSONObject
                //JSONObject contact = userDetail.getJSONObject("contact");
                // fetch mobile number and store it in arraylist
               // mobileNumbers.add(contact.getString("mobile"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, docNames, designations, hospitals);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView

    }

    /*public String loadJSONFromAsset() {
        String json = "";
        try {
            InputStream is = getAssets().open("myJsonFile0.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            //Toast.makeText(this,"wrong here",Toast.LENGTH_LONG);
            return null;
        }
        return json;
    }*/
   public String loadJSONFromAsset() {
       String json;
       try {
           InputStream inputStream = getAssets().open("myJsonFile0.json");
           int size = inputStream.available();
           byte[] byteArray = new byte[size];
           inputStream.read(byteArray);
           inputStream.close();
           json = new String(byteArray, StandardCharsets.UTF_8);
       } catch (IOException e) {
           e.printStackTrace();
           return null;
       }
       return json;
   }
    }


